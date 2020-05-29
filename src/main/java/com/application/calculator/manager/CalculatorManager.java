package com.application.calculator.manager;

import java.util.List;

public interface CalculatorManager {

    /**
     * This method validates the input for each calculation before performing actual calculation.
     * It ensures that the integrity of the system is maintained.
     * @param operand1 operand1 to be validated
     * @param operand2 operand2 to be validated
     * @param operation operation to be validated
     * @return
     */
    String[] validateOperation(String operand1, String operand2, String operation);

    /**
     * This method performs the calculation and adds the details in the logs.
     * @param operation operation to be performed
     * @return returns the calculated result
     */
    float addOperation(String operation);

    /**
     * This method returns the latest 10 calculations from logs.
     * @param pageSize optional pageSize
     * @return list of operations
     */
    List<String> getOperations(int pageSize);
}
