package org.example;

import org.example.model.CronField;
import org.example.model.CronParsedResponse;
import org.example.startegy.ParsingStrategy;

public class CronExpressionParseManager {
    private ParsingStrategy parsingStrategy;

    public CronExpressionParseManager(ParsingStrategy parsingStrategy) {
        this.parsingStrategy = parsingStrategy;
    }

    public CronParsedResponse parseString(String cronExpression) {
        CronParsedResponse response = new CronParsedResponse();
        String[] fields = cronExpression.split("\\s+", Constants.CRON_ARGUMENTS_LEN);

        response.setDaysOfMonth(parsingStrategy.getExecutableTimings(CronField.DAY_OF_MONTH, fields[2]));
        response.setMinutes(parsingStrategy.getExecutableTimings(CronField.MINUTE, fields[0]));
        response.setHours(parsingStrategy.getExecutableTimings(CronField.HOUR, fields[1]));
        response.setDaysOfWeek(parsingStrategy.getExecutableTimings(CronField.DAY_OF_WEEK, fields[4]));
        response.setMonth(parsingStrategy.getExecutableTimings(CronField.MONTH, fields[3]));

        response.setCommand(fields[5]);

        return response;
    }
}
