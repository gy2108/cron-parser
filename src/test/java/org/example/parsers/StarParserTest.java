package org.example.parsers;

import org.example.model.CronField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StarParserTest {
    StarParser parser = new StarParser();

    @Test
    void testcaseDayOfWeekPassed_1() {
        String cronExpression = "*";
        List<Integer> response = parser.getCronTimings(CronField.DAY_OF_WEEK, cronExpression);
        List<Integer> expected = List.of(1,2,3,4,5,6,7);
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testcaseHourPassed_2() {
        String cronExpression = "*";
        List<Integer> response = parser.getCronTimings(CronField.HOUR, cronExpression);
        List<Integer> expected = new ArrayList<>();
        for(int i=0;i<=23;i++){
            expected.add(i);
        }
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testcaseMonthPassed_3() {
        String cronExpression = "*";
        List<Integer> response = parser.getCronTimings(CronField.MONTH, cronExpression);
        List<Integer> expected = new ArrayList<>();
        for(int i=1;i<=12;i++){
            expected.add(i);
        }
        Assertions.assertEquals(expected, response);
    }

    @Test
    void testcaseMinutePassed_4() {
        String cronExpression = "*";
        List<Integer> response = parser.getCronTimings(CronField.MINUTE, cronExpression);
        List<Integer> expected = new ArrayList<>();
        for(int i=0;i<=59;i++){
            expected.add(i);
        }
        Assertions.assertEquals(expected, response);
    }

}