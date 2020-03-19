package com.nagarro.utils;
/*
* Class name - CsvUtil
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
* Description -  parse the csv
*/
import com.nagarro.constant.Constant;
import com.nagarro.models.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvUtil {

    public static List<Employee> getParsedData(MultipartFile file) {

        List<Employee> employees = new ArrayList<Employee>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            String row = null;
            String[] data = null;
            Employee employee;
            boolean firstRow = true;
            while ((row = reader.readLine()) != null) {
                if (firstRow) {
                    firstRow = false;
                } else {
                    data = row.split(Constant.CSV_SEPERATOR);
                    employee = new Employee();
                    employee.setEmployeeCode(Long.valueOf(data[0]));
                    employee.setEmployeeName(data[1]);
                    employee.setLocation(data[2]);
                    employee.setEmail(data[3]);
                    employee.setDateOfBirth(data[4]);
                    employees.add(employee);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

}