package ua.com.a_level.dao.impl;

import ua.com.a_level.dao.EmployeeDao;
import ua.com.a_level.entity.Employee;
import ua.com.a_level.jdbc.Jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmpDaoImp implements EmployeeDao {

    private final Connection connection = Jdbc.getCopy().getConnection();
    private final Statement statement = Jdbc.getCopy().getStatement();

    private static final String CREATE_EMPLOYEE = "insert into employee values (default,?, ?, ?, ?)";
    private static final String UPDATE_EMPLOYEE = "update employee set first_name = ?, last_name = ?, email = ?, age = ? where id = ?";
    private static final String DELETE_EMPLOYEE = "delete from employee where id = ?";
    private static final String FIND_EMPLOYEE_BY_ID = "select * from employee where id = ";
    private static final String FIND_ALL_EMPLOYEE = "select * from employee";
    private static final String EXIST_BY_FIRST_OR_LAST_NAME = "select count(*) as count_of_employee from employee " +
            "where first_name like ? or last_name like ?";

    @Override
    public void create(Employee employee) {
        try (PreparedStatement ps = connection.prepareStatement(CREATE_EMPLOYEE)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            ps.setInt(4, employee.getAge());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
    }

    @Override
    public void update(Employee employee) {
        try (PreparedStatement ps = connection.prepareStatement(UPDATE_EMPLOYEE)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getEmail());
            ps.setInt(4, employee.getAge());
            ps.setLong(5, employee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement ps = connection.prepareStatement(DELETE_EMPLOYEE)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
    }

    @Override
    public Employee findById(Long id) {
        try (ResultSet rs = statement.executeQuery(FIND_EMPLOYEE_BY_ID + id)) {
            rs.next();
            return convertResultSetToEmployee(rs);
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try (ResultSet rs = statement.executeQuery(FIND_ALL_EMPLOYEE)) {
            while (rs.next()) {
                employees.add(convertResultSetToEmployee(rs));
            }
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
        return employees;
    }

    @Override
    public boolean existByFirstOrLastName(String firstName, String lastName) {
        try (PreparedStatement ps = connection.prepareStatement(EXIST_BY_FIRST_OR_LAST_NAME)) {
            ps.setString(1, "%" + firstName + "%");
            ps.setString(2, "%" + lastName + "%");
            ResultSet rs = ps.executeQuery();
            rs.next();
            long count = rs.getLong("count_of_employee");
            return count > 0;
        } catch (SQLException e) {
            System.out.println("exception = " + e.getMessage());
        }
        return false;
    }

    private Employee convertResultSetToEmployee(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        Long id = rs.getLong("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        int age = rs.getInt("age");
        String email = rs.getString("email");
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setEmail(email);
        return employee;
    }
}
