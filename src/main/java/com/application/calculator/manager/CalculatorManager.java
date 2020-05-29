package com.application.calculator.manager;

import java.util.List;

public interface CalculatorManager {

    String[] validateOperation(String operand1, String operand2, String operation);

    void addOperation(String operation);

    List<String> getOperations(int pageSize);
}
