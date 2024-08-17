package org.example.parsers;

import org.example.exception.InvalidCronException;
import org.example.model.CronField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FixedTimingsParser extends FieldParser {

    @Override
    public List<Integer> getCronTimings(CronField cronField, String cronExpression) throws InvalidCronException {
        String[] timings = cronExpression.split(",");
        List<Integer> result = new ArrayList<>();

        for(String fixedTime : timings) {
            int time = Integer.parseInt(fixedTime);
            validate(time, cronField, cronExpression);
            result.add(time);
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public String getRegex() {
        return "^\\d+(,\\d+)*$";
    }

    private void validate(Integer value, CronField cronField, String expression) {
        if(value < cronField.getStartRange() || value > cronField.getEndRange())
            throw new InvalidCronException("Values passed are not in give range", expression, cronField);
    }
}
