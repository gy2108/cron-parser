package org.example.parsers;

import org.example.exception.InvalidCronException;
import org.example.model.CronField;

import java.util.List;

public class NumberParser extends FieldParser {

    @Override
    public List<Integer> getCronTimings(CronField cronField, String cronExpression) throws InvalidCronException {
        int value = Integer.parseInt(cronExpression);
        if(value < cronField.getStartRange() || value > cronField.getEndRange()) {
            throw new InvalidCronException("Values passed are not in give range", cronExpression, cronField);
        }
        return List.of(value);
    }

    @Override
    public String getRegex() {
        return "^\\d+$";
    }
}
