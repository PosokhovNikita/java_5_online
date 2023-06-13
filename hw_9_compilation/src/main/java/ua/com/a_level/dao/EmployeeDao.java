package ua.com.a_level.dao;

import ua.com.a_level.entity.Employee;

public interface EmployeeDao extends BaseDao<Employee>{

    boolean existByFirstOrLastName(String firstName, String lastName);
}
