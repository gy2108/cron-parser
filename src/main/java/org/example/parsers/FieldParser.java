package org.example.parsers;

import org.example.model.CronField;

import java.util.ArrayList;
import java.util.List;

public abstract class FieldParser {

    protected List<Integer> getCronTimingsByIncrement(Integer startRange, Integer endRange, Integer increment) {
        List<Integer> result = new ArrayList<>();
        while(startRange <= endRange) {
            result.add(startRange);
            startRange = startRange + increment;
        }
        return result;
    }

    public abstract List<Integer> getCronTimings(CronField field, String cronExpression);
    public abstract String getRegex();

}
