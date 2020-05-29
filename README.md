## CALCULATOR API

This is a simple application to process calculation operations which supports 
addition, subtraction, division and multiplication. This application also logs calculations
and share those calculations among users, currently active on website. It maintains these 
calculations among sessions. Basic validation for calculations is also added and appropriate 
error messages will be displayed to the user.

Please refer following url mappings to perform calculations:

1) /api/calculator/getLatestCalculations

    This api will get recent 10 calculations across all users.
    (Optional Parameter) 
    pageSize = number of recent calculations you want (default = 10)
    
2) /api/calculator/addCalculation

    This api will add a new calculation from a user and logs the calculation for future reference.
    (Required Parameters) 
    operand = operation to be performed (value = "+", "-" , "/" and "*")
        Note - "+" and " "(single space) are interchangeable,  provided GET request constraints
    operand1 = value of first operand
    operand2 = value of second operand
    
This is a simple calculator application developed and deployed in Spring with documentation.
Please let me know your suggestions. 
        