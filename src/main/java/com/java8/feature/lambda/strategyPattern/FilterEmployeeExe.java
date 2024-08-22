package com.java8.feature.lambda.strategyPattern;

import com.java8.feature.lambda.entity.Employee;
import com.java8.feature.lambda.strategyPattern.abs.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterEmployeeExe {
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    protected List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 60, 6666.66),
            new Employee("赵六", 16, 7777.77),
            new Employee("田七", 18, 3333.33)
    );
    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> myPredicate) {
        List<Employee> employees = new ArrayList<>();
        for(Employee e : list){
            if(myPredicate.filter(e)){
                employees.add(e);
            }
        }
        return employees;
    }

}
