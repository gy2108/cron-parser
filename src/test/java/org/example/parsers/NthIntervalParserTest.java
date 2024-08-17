package org.example.parsers;

import org.example.exception.InvalidCronException;
import org.example.model.CronField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class NthIntervalParserTest {
    NthIntervalParser parser = new NthIntervalParser();

    @Test
    void testcaseDayOfMonthPassed_1() {
        String cronExpression = "*/5";
        List<Integer> response = parser.getCronTimings(CronField.DAY_OF_MONTH, cronExpression);
        List<Integer> expected = List.of(1,6,11,16,21,26,31);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testcaseHourPassed_2() {
        String cronExpression = "*/3";
        List<Integer> response = parser.getCronTimings(CronField.HOUR, cronExpression);
        List<Integer> expected = List.of(0,3,6,9,12,15,18,21);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testcaseMinutePassed_3() {
        String cronExpression = "*/10";
        List<Integer> response = parser.getCronTimings(CronField.MINUTE, cronExpression);
        List<Integer> expected = List.of(0,10,20,30,40,50);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testcaseInvalidHourIntervalException_1() {
        String cronExpression = "*/24";
        Assertions.assertThrows(InvalidCronException.class, () -> {
            parser.getCronTimings(CronField.HOUR, cronExpression);
        });
    }

    @Test
    void testcaseInvalidDayOfWeekException_2() {
        String cronExpression = "*/8";
        Assertions.assertThrows(InvalidCronException.class, () -> {
            parser.getCronTimings(CronField.DAY_OF_WEEK, cronExpression);
        });
    }

    @Test
    void testcaseInvalidDayOfMonthException_3() {
        String cronExpression = "*/32";
        Assertions.assertThrows(InvalidCronException.class, () -> {
            parser.getCronTimings(CronField.DAY_OF_MONTH, cronExpression);
        });
    }


}