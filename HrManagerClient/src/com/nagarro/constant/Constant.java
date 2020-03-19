package com.nagarro.constant;
/*
* Class name - Constant
*
* Version info - 0.3
*
* Copyright notice - @2020 Nagarro Private Limited.
* 
* Author info - Vishavjeet Singh
*
* Creation date - 17-03-2020
*
* Last updated By - Vishavjeet Singh
*
* Last updated Date - 19-03-2020
*
* Description -  contains all the constants
*/
public class Constant {
	public static final String REST_URL = "http://localhost:8989/EmployeeManagementRest/";
	public static final String GET_ALL_EMPLOYEES = "employees/";
	public static final String PUT_EMPLOYEE = "employee/";
	public static final String GET_EMPLOYEE = "employee/";
    public static final String POST_EMPLOYEE = "employee/";
	public static final String CSV_SEPERATOR = ",";
    public static final String CSV_FILE_NAME = "EmployeeData.csv";
    public static final String[] DISPLAY_HEADER = {"Id", "Employee Code", "Employee Name", "Location", "Email", "Date Of Birth"};
    public static final String[] BEAN_HEADER = {"id", "employeeCode", "employeeName", "location", "email", "dateOfBirth"};
    
    private static Constant constantParamsObject = null;
    private Constant() {
        super();
    }
    public static final Constant getObject() {
        if (constantParamsObject == null) {
            constantParamsObject = new Constant();
        }
        return constantParamsObject;
    }
}
