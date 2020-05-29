package com.application.calculator.manager;

import com.application.calculator.model.Operation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

@Service
public class CalculatorManagerImpl implements CalculatorManager{

    private Stack<Operation> operationsStack = new Stack<>();

    @Override
    public String[] validateOperation(String operand1, String operand2, String operation) {

        String operationStr = "";
        String[] result = new String[2];

        String regex = "[+-]?[0-9][0-9]*";
        String regexFloat = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";

        if(operation.equals(" "))
            operation = "+";

        if( (!operand1.matches(regex) || !operand2.matches(regex)) &&
                (!operand1.matches(regexFloat) || !operand2.matches(regexFloat))){
            result[0] = "error";
            result[1] = "Incorrect operand";
        }
        else if(operation.equals("/") && Float.parseFloat(operand2)  == 0){
            result[0] = "error";
            result[1] = "Cannot Divide by Zero";
        }else if(!(operation.equals("/") || operation.equals("*")  || operation.equals("-")  || operation.equals("+"))){
            result[0] = "error";
            result[1] = "Incorrect operation";
        }else{
            operationStr = operand1 + " " + operation + " " + operand2;
            result[0] = "valid";
            result[1] = operationStr;
        }


        return result;
    }

    @Override
    public void addOperation(String operation) {
        Operation operationObj = new Operation();
        float answer = 0.0f;
        if(operation.contains("+")){
            String[] values = operation.split("\\+");
            answer = Float.parseFloat(values[0]) + Float.parseFloat(values[1]);
        }else if(operation.contains("-")){
            String[] values = operation.split("-");
            answer = Float.parseFloat(values[0]) - Float.parseFloat(values[1]);
        }else if(operation.contains("/")){
            String[] values = operation.split("/");
            answer = Float.parseFloat(values[0]) / Float.parseFloat(values[1]);
        }else if(operation.contains("*")){
            String[] values = operation.split("\\*");
            answer = Float.parseFloat(values[0]) * Float.parseFloat(values[1]);
        }

        operationObj.setAnswer(answer);
        operationObj.setOperation(operation);
        operationObj.setTimestamp(new Date());
        operationsStack.push(operationObj);

    }

    @Override
    public List<String> getOperations(int pageSize) {
        List<String> operations = new ArrayList<>();
        int i = operationsStack.size() - 1;
        while(i >= 0  && operations.size() < pageSize){
            operations.add(operationsStack.get(i).toString());
            i--;
        }
        return operations;
    }
}
