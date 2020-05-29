package com.application.calculator.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class stores each calculation details with its timestamp.
 */
public class Operation {

    private String operation;
    private float answer;
    private Date timestamp;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public float getAnswer() {
        return answer;
    }

    public void setAnswer(float answer) {
        this.answer = answer;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String toString(){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        df.format(timestamp);
        String str = operation + " = " + answer + " @ " + df.format(timestamp);
        return str + "\n";
    }

}
