package org.example;

import org.example.exception.InvalidCronException;
import org.example.model.CronParsedResponse;
import org.example.parsers.*;
import org.example.startegy.ParsingStrategy;
import org.example.startegy.ParsingStrategyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class CronExpressionParseManagerTest {
    static CronExpressionParseManager parseManager;

    @BeforeAll
    public static void init() {
        ParsingStrategy manager = new ParsingStrategyService();
        manager.registerStrategy(new NumberParser());
        manager.registerStrategy(new StarParser());
        manager.registerStrategy(new NthIntervalParser());
        manager.registerStrategy(new FixedTimingsParser());
        manager.registerStrategy(new RangeIntervalsParser());
        parseManager = new CronExpressionParseManager(manager);
    }

    @Test
    void testcaseValidExpressionPassed_1() {
        String cronExpression = "*/15 0 1,15 * 1-5 /usr/bin/find";
        String expected =
                        "minute        0 15 30 45\n" +
                        "hour          0\n" +
                        "day of month  1 15\n" +
                        "month         1 2 3 4 5 6 7 8 9 10 11 12\n" +
                        "day of week   1 2 3 4 5\n" +
                        "command       /usr/bin/find";

        CronParsedResponse response = parseManager.parseString(cronExpression);
        System.out.println(response);
        Assertions.assertTrue(expected.equals(response.toString()));
    }

    @Test
    void testcaseValidExpressionWithMultipleSpacePassed_2() {
        String cronExpression = "*/15 0    1,15    * 1-5 /usr/bin/find args1 args2";
        String expected =
                "minute        0 15 30 45\n" +
                        "hour          0\n" +
                        "day of month  1 15\n" +
                        "month         1 2 3 4 5 6 7 8 9 10 11 12\n" +
                        "day of week   1 2 3 4 5\n" +
                        "command       /usr/bin/find args1 args2";

        CronParsedResponse response = parseManager.parseString(cronExpression);
        System.out.println(response);
        Assertions.assertTrue(expected.equals(response.toString()));
    }

    @Test
    void testcaseInvalidFieldRangeException_1() {
        String cronExpression = "*/100 0 1,15 * 1-5 /usr/bin/find";
        Assertions.assertThrows(InvalidCronException.class, () -> {
            parseManager.parseString(cronExpression);
        });
    }

}