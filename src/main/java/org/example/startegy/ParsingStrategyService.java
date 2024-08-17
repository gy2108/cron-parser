package org.example.startegy;

import org.example.parsers.FieldParser;
import org.example.exception.InvalidCronException;
import org.example.model.CronField;

import java.util.*;

public class ParsingStrategyService implements ParsingStrategy{
    private Set<FieldParser> parserList = new HashSet<>();

    @Override
    public void registerStrategy(FieldParser parser) {
        parserList.add(parser);
    }

    @Override
    public List<Integer> getExecutableTimings(CronField cronField, String cronExpression) {
        FieldParser parser;
        try {
            parser = getParser(cronExpression);
        } catch (InvalidCronException exp) {
            throw new InvalidCronException(exp.getMessage(), cronExpression, cronField);
        }
        return parser.getCronTimings(cronField, cronExpression);
    }

    private FieldParser getParser(String cronExpression) {
        for(FieldParser parser : parserList) {
            if(cronExpression.matches(parser.getRegex())) {
                return parser;
            }
        }
        throw new InvalidCronException("Expression not Valid !!");
    }
}
