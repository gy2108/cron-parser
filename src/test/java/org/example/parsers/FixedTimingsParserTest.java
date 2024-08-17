package org.example.parsers;

import org.example.exception.InvalidCronException;
import org.example.model.CronField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class FixedTimingsParserTest {
    FixedTimingsParser parser = new FixedTimingsParser();

    @Test
    void testcaseDayOfMonthPassed_1() {
        String cronExpression = "5,10";
        List<Integer> response = parser.getCronTimings(CronField.DAY_OF_MONTH, cronExpression);
        List<Integer> expected = List.of(5,10);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testcaseHourPassed_2() {
        String cronExpression = "22,23";
        List<Integer> response = parser.getCronTimings(CronField.HOUR, cronExpression);
        List<Integer> expected = List.of(22,23);
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
        String cronExpression = "8";
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