package org.example.parsers;

import org.example.exception.InvalidCronException;
import org.example.model.CronField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RangeIntervalsParserTest {

    RangeIntervalsParser parser = new RangeIntervalsParser();

    @Test
    void testcaseDayOfMonthPassed_1() {
        String cronExpression = "1-5";
        List<Integer> response = parser.getCronTimings(CronField.DAY_OF_MONTH, cronExpression);
        List<Integer> expected = List.of(1,2,3,4,5);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testcaseHourPassed_2() {
        String cronExpression = "8-10,1-5";
        List<Integer> response = parser.getCronTimings(CronField.HOUR, cronExpression);
        List<Integer> expected = List.of(1,2,3,4,5,8,9,10);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testcaseInvalidHourException_1() {
        String cronExpression = "1-24";
        Assertions.assertThrows(InvalidCronException.class, () -> {
            parser.getCronTimings(CronField.HOUR, cronExpression);
        });
    }

    @Test
    void testcaseInvalidDayOfWeekException_2() {
        String cronExpression = "5-10";
        Assertions.assertThrows(InvalidCronException.class, () -> {
            parser.getCronTimings(CronField.DAY_OF_WEEK, cronExpression);
        });
    }

    @Test
    void testcaseInvalidDayOfMonthException_3() {
        String cronExpression = "20-32";
        Assertions.assertThrows(InvalidCronException.class, () -> {
            parser.getCronTimings(CronField.DAY_OF_MONTH, cronExpression);
        });
    }

}