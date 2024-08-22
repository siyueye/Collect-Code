package com.java8.feature.lambda.strategyPattern;
import com.java8.feature.lambda.entity.Employee;
import com.java8.feature.lambda.strategyPattern.abs.MyPredicate;

public class FilterEmployeeByAge  implements MyPredicate<Employee> {
    /**
     * 过滤年龄大于或者等于30的员工信息
     * @param employee
     * @return
     */
    @Override
    public boolean filter(Employee employee) {
        return employee.getAge() >= 30;
    }
}
