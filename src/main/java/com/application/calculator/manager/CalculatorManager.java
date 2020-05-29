package com.application.calculator.manager;

import java.util.List;


public interface CalculatorManager {

    public String[] validateOperation(String operand1, String operand2, String operation);

    public void addOperation(String operation);

    public List<String> getOperations(int pageSize);
}
