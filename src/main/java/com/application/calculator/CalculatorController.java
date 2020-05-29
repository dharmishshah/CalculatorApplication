package com.application.calculator;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/calculator")
@CrossOrigin("*")
public class CalculatorController {

    @RequestMapping(value="/getLatestCalculations",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> getLatestCalculations (HttpServletRequest request, HttpServletResponse response,
                                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                                                              int pageSize) {
        Map<String, String> resultMap = new HashMap<>();
        System.out.println("pageSize + " + pageSize);
        resultMap.put("status1", "success");
        return resultMap;

    }

    @RequestMapping(value="/addCalculation",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, String> addCalculation (HttpServletRequest request, HttpServletResponse response,
                                               @RequestParam("operation") String operation) {
        Map<String, String> resultMap = new HashMap<>();
        System.out.println("operation + " + operation);
        resultMap.put("status2", "success");
        return resultMap;

    }
}
