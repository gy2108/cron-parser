package org.example.parsers;

import org.example.exception.InvalidCronException;
import org.example.model.CronField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.List;

class NumberParserTest {

    NumberParser parser = new NumberParser();

    @Test
    void testcaseDayOfMonthPassed_1() {
        String cronExpression = "10";
        List<Integer> response = parser.getCronTimings(CronField.DAY_OF_MONTH, cronExpression);
        List<Integer> expected = List.of(10);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testcaseDayOfWeekPassed_2() {
        String cronExpression = "1";
        List<Integer> response = parser.getCronTimings(CronField.DAY_OF_WEEK, cronExpression);
        List<Integer> expected = List.of(1);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testcaseHourPassed_3() {
        String cronExpression = "20";
        List<Integer> response = parser.getCronTimings(CronField.HOUR, cronExpression);
        List<Integer> expected = List.of(20);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testcaseInvalidHourException_1() {
        String cronExpression = "24";
        Assertions.assertThrows(InvalidCronException.class, () -> {
            parser.getCronTimings(CronField.HOUR, cronExpression);
        });
    }

    @Test
    void testcaseInvalidDayOfWeekException_2() {
        String cronExpression = "10";
        Assertions.assertThrows(InvalidCronException.class, () -> {
            parser.getCronTimings(CronField.DAY_OF_WEEK, cronExpression);
        });
    }

    @Test
    void testcaseInvalidDayOfMonthException_3() {
        String cronExpression = "32";
        Assertions.assertThrows(InvalidCronException.class, () -> {
            parser.getCronTimings(CronField.DAY_OF_MONTH, cronExpression);
        });
    }
}