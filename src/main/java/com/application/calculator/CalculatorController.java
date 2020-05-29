package com.application.calculator;

import com.application.calculator.manager.CalculatorManager;
import com.application.calculator.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/calculator")
@CrossOrigin("*")
public class CalculatorController {

    @Autowired
    CalculatorManager calculatorManager;

    @RequestMapping(value="/getLatestCalculations",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getLatestCalculations (HttpServletRequest request, HttpServletResponse response,
                                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                                              int pageSize) {
        Map<String, Object> resultMap = new HashMap<>();
        List<String> operations = calculatorManager.getOperations(pageSize);
        resultMap.put("status", "success");
        resultMap.put("operations", operations);
        return resultMap;

    }

    @RequestMapping(value="/addCalculation",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> addCalculation (HttpServletRequest request, HttpServletResponse response,
                                               @RequestParam("operation") String operation,
                                               @RequestParam("operand1") String operand1,
                                               @RequestParam("operand2") String operand2) {
        Map<String, String> resultMap = new HashMap<>();
        String[] validate = calculatorManager.validateOperation(operand1, operand2, operation);
        if(validate[0].equals("valid")){
            calculatorManager.addOperation(validate[1]);
            resultMap.put("status", "success");
        }else{
            resultMap.put("status", "failure");
            resultMap.put("errorMessage", validate[1]);
        }
        return resultMap;
    }
}
