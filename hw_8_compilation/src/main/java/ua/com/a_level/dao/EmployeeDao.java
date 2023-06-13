package ua.com.a_level.dao;

import org.json.simple.parser.ParseException;
import ua.com.a_level.entity.Employee;

import java.io.IOException;
import java.util.ArrayList;

public interface EmployeeDao {

    void readEmployee() throws ParseException, IOException;

    void createEmployee(Employee employee) throws IOException;

    void updateEmployee(int index, Employee employee);

    void deleteEmployee(int index);

    Employee findEmployeeById(String id);

    ArrayList<Employee> findAllEmployee();
}
