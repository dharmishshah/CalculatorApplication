package com.application.calculator.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculatorErrorController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public Map<String, String> handleError() {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("error", "Incorrect mapping specified or required parameters are missing");
        resultMap.put("hint", "Please read README file to refer url mappings");
        return resultMap;
    }
}
