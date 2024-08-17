package org.example.parsers;

import org.example.Constants;
import org.example.exception.InvalidCronException;
import org.example.model.CronField;

import java.util.List;

public class NthIntervalParser extends FieldParser{

    @Override
    public List<Integer> getCronTimings(CronField cronField, String cronExpression) throws InvalidCronException {
        String intervalString = cronExpression.substring(Constants.NTH_INTERVAL_FORMAT.length());
        int interval = Integer.parseInt(intervalString);

        if(interval < cronField.getStartRange() || interval > cronField.getEndRange()) {
            throw new InvalidCronException("Values passed are not in give range", cronExpression, cronField);
        }
        return getCronTimingsByIncrement(cronField.getStartRange(), cronField.getEndRange(), interval);
    }

    @Override
    public String getRegex() {
        return "^\\*/\\d+$";
    }
}
