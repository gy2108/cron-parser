package org.example.parsers;

import org.example.model.CronField;

import java.util.List;

public class StarParser extends FieldParser {

    @Override
    public List<Integer> getCronTimings(CronField cronField, String cronExpression) {
        return getCronTimingsByIncrement(cronField.getStartRange(), cronField.getEndRange(), 1);
    }

    @Override
    public String getRegex() {
        return "^\\*$";
    }
}
