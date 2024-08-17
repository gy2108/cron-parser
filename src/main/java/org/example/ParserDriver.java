package org.example;

import org.example.exception.InvalidCronException;
import org.example.model.CronParsedResponse;
import org.example.parsers.*;
import org.example.startegy.ParsingStrategy;
import org.example.startegy.ParsingStrategyService;


public class ParserDriver {

    public static void main(String[] args) {

        if (args.length != 1 || args[0].split(" ", Constants.CRON_ARGUMENTS_LEN).length != Constants.CRON_ARGUMENTS_LEN) {
            System.err.println("Invalid Arguments Passed");
            return;
        }

        ParsingStrategy parserStrategyManager = new ParsingStrategyService();
        FieldParser starParser = new StarParser();
        parserStrategyManager.registerStrategy(starParser);

        FieldParser numberParser = new NumberParser();
        parserStrategyManager.registerStrategy(numberParser);

        FieldParser fixedTimingsParser = new FixedTimingsParser();
        parserStrategyManager.registerStrategy(fixedTimingsParser);

        FieldParser nthIntervalParser = new NthIntervalParser();
        parserStrategyManager.registerStrategy(nthIntervalParser);

        FieldParser boundIntervalsParser = new RangeIntervalsParser();
        parserStrategyManager.registerStrategy(boundIntervalsParser);

        CronExpressionParseManager cronExpressionParser = new CronExpressionParseManager(parserStrategyManager);

        CronParsedResponse response = new CronParsedResponse();
        try{
            response = cronExpressionParser.parseString(args[0]);
            System.out.println(response);
        } catch (InvalidCronException ex) {
            System.err.println(ex.getMessage());
        }
    }
}