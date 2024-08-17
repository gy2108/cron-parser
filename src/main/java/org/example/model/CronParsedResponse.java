package org.example.model;

import org.example.Constants;

import java.util.List;
import java.util.StringJoiner;


public class CronParsedResponse {
    private List<Integer> minutes;
    private List<Integer> hours;
    private List<Integer> daysOfMonth;
    private List<Integer> month;
    private List<Integer> daysOfWeek;
    private String command;

    public void setMinutes(List<Integer> minutes) {
        this.minutes = minutes;
    }

    public void setHours(List<Integer> hours) {
        this.hours = hours;
    }

    public void setDaysOfMonth(List<Integer> daysOfMonth) {
        this.daysOfMonth = daysOfMonth;
    }

    public void setMonth(List<Integer> month) {
        this.month = month;
    }

    public void setDaysOfWeek(List<Integer> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        this.addColumnNameWithSpaces(str, CronField.MINUTE.getFieldName());
        str.append(getValues(minutes));
        str.append("\n");

        this.addColumnNameWithSpaces(str, CronField.HOUR.getFieldName());
        str.append(getValues(hours));
        str.append("\n");

        this.addColumnNameWithSpaces(str, CronField.DAY_OF_MONTH.getFieldName());
        str.append(getValues(daysOfMonth));
        str.append("\n");

        this.addColumnNameWithSpaces(str, CronField.MONTH.getFieldName());
        str.append(getValues(month));
        str.append("\n");

        this.addColumnNameWithSpaces(str, CronField.DAY_OF_WEEK.getFieldName());
        str.append(getValues(daysOfWeek));
        str.append("\n");

        this.addColumnNameWithSpaces(str, Constants.Command);
        str.append(command);

        return str.toString();
    }

    private void addColumnNameWithSpaces(StringBuilder str, String fieldName){
        str.append(fieldName);
        for(int index = 0; index<Constants.Field_Name_Column_Length-fieldName.length(); index++){
            str.append(" ");
        }
    }

    private String getValues(List<Integer> integers) {
        StringJoiner result = new StringJoiner(" ");
        for (Integer intValue : integers) {
            result.add(String.valueOf(intValue));
        }
        return result.toString();
    }
}
