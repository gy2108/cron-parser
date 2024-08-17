package org.example.exception;

import org.example.model.CronField;

public class InvalidCronException extends RuntimeException{
    public InvalidCronException(String message) {
        super(message);
    }

    public InvalidCronException(String message, String expression, CronField field) {
        StringBuilder messageStr = new StringBuilder();
        messageStr.append("The Cron Expression " + expression + " given in arguments " + field.getFieldName() + " is invalid.");
        messageStr.append("\n");
        messageStr.append("Valid range is " + " between " + field.getStartRange() +" to " + field.getEndRange());
        messageStr.append("\n");
        messageStr.append("ERROR: " + message);

        throw new InvalidCronException(messageStr.toString());
    }
}
