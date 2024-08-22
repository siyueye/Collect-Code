package java8.feature.lambda;

import com.java8.feature.lambda.entity.Employee;
import com.java8.feature.lambda.strategyPattern.FilterEmployeeByAge;
import com.java8.feature.lambda.strategyPattern.FilterEmployeeBySalary;
import com.java8.feature.lambda.strategyPattern.FilterEmployeeExe;
import com.java8.feature.lambda.strategyPattern.abs.MyPredicate;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FilterEmployeeTest {
    FilterEmployeeExe flt = new FilterEmployeeExe();
    /**
     * 匿名内部类
     */
    @Test
    public void test1(){
        List<Employee> employeeList = flt.filterEmployee(flt.getEmployees(), new
                MyPredicate<Employee>() {
                    @Override
                    public boolean filter(Employee employee) {
                        return employee.getAge() >= 30;
                    }
                });
        for (Employee e : employeeList){
            System.out.println(e);
        }
    }
    /**
     * 匿名内部类
     */
    @Test
    public void test2(){
        List<Employee> employeeList = flt.filterEmployee(flt.getEmployees(), new
                MyPredicate<Employee>() {
                    @Override
                    public boolean filter(Employee employee) {
                        return employee.getSalary() >= 5000;
                    }
                });
        for (Employee e : employeeList){
            System.out.println(e);
        }
    }
    @Test
    public void test3(){
        List<Employee> employeeList= flt.filterEmployee(flt.getEmployees(),new FilterEmployeeByAge());
        for (Employee e :employeeList){
            System.out.println(e.toString());
        }
    }
    @Test
    public void test4(){
        List<Employee> employeeList = flt.filterEmployee(flt.getEmployees(), new
                FilterEmployeeBySalary());
        for (Employee e : employeeList){
            System.out.println(e);
        }
    }

    @Test
    public void test5(){
        flt.filterEmployee(flt.getEmployees(), (e) -> e.getAge() >=
                30).forEach(System.out::println);
    }
    @Test
    public void test6(){
        flt.getEmployees().stream().filter((e) -> e.getSalary() >=
                5000).forEach(System.out::println);
    }

    @Test
    public void test7(){
        flt.getEmployees().stream().filter((e) -> e.getSalary() >=
                5000).limit(2).forEach(System.out::println);
    }
    @Test
    public void test8(){
        flt.getEmployees().stream().filter((e) -> e.getSalary() >=
                5000).map(Employee::getName).forEach(System.out::println);
    }
}
