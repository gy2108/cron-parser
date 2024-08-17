package org.example.model;

public enum CronField {
    DAY_OF_MONTH("day of month", 1, 31),
    HOUR("hour", 0, 23),
    MONTH("month", 1 , 12),
    DAY_OF_WEEK("day of week", 1, 7),
    MINUTE("minute", 0, 59);

    private String cronFieldName;
    private int startRange;
    private int endRange;

    CronField(String cronFieldName, int startRange, int endRange) {
        this.cronFieldName = cronFieldName;
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public String getFieldName(){
        return this.cronFieldName;
    }
    public int getStartRange(){
        return this.startRange;
    }
    public int getEndRange(){
        return this.endRange;
    }
}
