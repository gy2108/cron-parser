package org.example.parsers;

import org.example.exception.InvalidCronException;
import org.example.model.CronField;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RangeIntervalsParser extends FieldParser {

    @Override
    public List<Integer> getCronTimings(CronField cronField, String cronExpression) throws InvalidCronException {
        String[] intervals = cronExpression.split(",");
        List<Integer> result = new ArrayList<>();

        for(String interval : intervals) {
            String[] ranges = interval.split("-");
            int startInterval = Integer.parseInt(ranges[0]);
            int endInterval = Integer.parseInt(ranges[1]);

            validate(startInterval, endInterval, cronField, cronExpression);
            result.addAll(getCronTimingsByIncrement(startInterval, endInterval, 1));
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public String getRegex() {
        return "^\\d+-\\d+(,\\d+-\\d+)*$";
    }

    private void validate(Integer startInterval, Integer endInterval, CronField cronField, String cronExpression) {
         if(startInterval < cronField.getStartRange()
                 || startInterval > cronField.getEndRange()
                 || startInterval > endInterval
                 || endInterval > cronField.getEndRange()){
             throw new InvalidCronException("Values passed are not in give range", cronExpression, cronField);
         }
    }
}
