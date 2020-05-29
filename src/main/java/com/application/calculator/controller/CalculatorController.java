package com.application.calculator.controller;

import com.application.calculator.manager.CalculatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a calculator controller which serves all operations involved in a typical calculator.
 */
@RestController
@RequestMapping(value = "/api/calculator")
@CrossOrigin("*")
public class CalculatorController {

    @Autowired
    CalculatorManager calculatorManager;

    /**
     *  This request method gets 10 latest calculations from the logs. You can also customise the number of latest
     *  transactions by giving optional parameter of pageSize
     * @param pageSize optional parameter to specify number of latest calculations from logs
     * @return
     */
    @RequestMapping(value="/getLatestCalculations",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getLatestCalculations (@RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                                              int pageSize) {
        Map<String, Object> resultMap = new HashMap<>();
        List<String> operations = calculatorManager.getOperations(pageSize);
        resultMap.put("status", "success");
        resultMap.put("operations", operations);
        return resultMap;

    }

    /**
     * This method performs a operation with the provided operands and operation.
     * Operation can be +, -, / and * for respective operation.
     * @param operation operation to be performed (addition, subtraction, division and multiplication)
     * @param operand1 operand1
     * @param operand2 operand2
     * @return
     */
    @RequestMapping(value="/addCalculation",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> addCalculation (HttpServletRequest request, HttpServletResponse response,
                                               @RequestParam("operation") String operation,
                                               @RequestParam("operand1") String operand1,
                                               @RequestParam("operand2") String operand2) {
        Map<String, String> resultMap = new HashMap<>();
        String[] validate = calculatorManager.validateOperation(operand1, operand2, operation);
        if(validate[0].equals("valid")){
            float answer = calculatorManager.addOperation(validate[1]);
            resultMap.put("status", "success");
            resultMap.put("answer", "" + answer);
        }else{
            resultMap.put("status", "failure");
            resultMap.put("errorMessage", validate[1]);
        }
        return resultMap;
    }




}
