package com.java8.feature.lambda.strategyPattern;

import com.java8.feature.lambda.entity.Employee;
import com.java8.feature.lambda.strategyPattern.abs.MyPredicate;

public class FilterEmployeeBySalary  implements MyPredicate<Employee> {
    @Override
    public boolean filter(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
