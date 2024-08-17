package org.example.startegy;

import org.example.parsers.FieldParser;
import org.example.model.CronField;

import java.util.List;

public interface ParsingStrategy {
    void registerStrategy(FieldParser parser);

    List<Integer> getExecutableTimings(CronField field, String cronExpression);
}
