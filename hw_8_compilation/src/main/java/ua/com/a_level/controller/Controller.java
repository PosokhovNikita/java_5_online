package ua.com.a_level.controller;

import ua.com.a_level.dao.EmployeeDao;
import ua.com.a_level.dao.RelationDao;
import ua.com.a_level.dao.SpecializationDao;
import ua.com.a_level.entity.Employee;
import ua.com.a_level.entity.Specialization;
import ua.com.a_level.service.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Controller {

    private EmployeeDao employeeDao = new Service();
    private SpecializationDao specializationDao = new Service();
    private RelationDao relationDao = new Service();


    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        menu();
        while ((str = bf.readLine()) != null) {
            choice(bf, str);
        }

    }

    public void menu() {
        System.out.println();
        System.out.println("=============================================");
        System.out.println("|                   MENU                    |");
        System.out.println("=============================================");
        System.out.println("|           SPECIALIZATION                  |");
        System.out.println("| 1. Create Specialization                  |");
        System.out.println("| 2. Update Specialization                  |");
        System.out.println("| 3. Delete Specialization                  |");
        System.out.println("| 4. Find Specialization by ID              |");
        System.out.println("| 5. Find all specialization                |");
        System.out.println("|              EMPLOYEE                     |");
        System.out.println("| 6. Create Employee                        |");
        System.out.println("| 7. Update Employee                        |");
        System.out.println("| 8. Delete Employee                        |");
        System.out.println("| 9. Find Employee by ID                    |");
        System.out.println("| 10. Find all Employee                     |");
        System.out.println("|               ACTION                      |");
        System.out.println("| 11. Find all Employee by Specialization   |");
        System.out.println("| 12. Add Employee To Specialization        |");
        System.out.println("| 13. Find all Specialization with Employee |");
        System.out.println("| 0. Exit                                   |");
        System.out.println("=============================================");
        System.out.println();

    }

    private void exit() {
        System.out.println("Good Bye!");
        System.exit(0);
    }

    private void choice(BufferedReader bf, String str) throws IOException {
        switch (str) {
            case "1" -> createSpecialization(bf);
            case "2" -> updateSpecialization(bf);
            case "3" -> deleteSpecialization(bf);
            case "4" -> findSpecializationById(bf);
            case "5" -> findAllSpecialization();
            case "6" -> createEmployee(bf);
            case "7" -> updateEmployee(bf);
            case "8" -> deleteEmployee(bf);
            case "9" -> findEmployeeById(bf);
            case "10" -> findAllEmployee();
            case "11" -> findAllEmployeeBySpecialization(bf);
            case "12" -> attachEmployeeToSpecialization(bf);
            case "13" -> findAllSpecializationByEmployee(bf);
            case "0" -> exit();
        }
        menu();
    }

    private void listEmployee() {
        ArrayList<Employee> employees = employeeDao.findAllEmployee();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + " - " + employees.get(i));
        }
    }

    private void listSpecialization() {
        ArrayList<Specialization> specializations = specializationDao.findAllSpecialization();
        for (int i = 0; i < specializations.size(); i++) {
            System.out.println((i + 1) + " - " + specializations.get(i));
        }
    }

    private void createEmployee(BufferedReader bf) throws IOException {
        System.out.println("Please enter the first name: ");
        String firstName = bf.readLine();
        System.out.println("Please enter the last name: ");
        String lastName = bf.readLine();
        System.out.println("Please enter the age: ");
        int age = Integer.parseInt(bf.readLine());
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employeeDao.createEmployee(employee);
    }

    private void updateEmployee(BufferedReader bf) throws IOException {
        listEmployee();
        System.out.println("Enter index Employee: ");
        int employeeIndex = Integer.valueOf(bf.readLine());
        System.out.println("Enter new first name: ");
        String firstName = bf.readLine();
        System.out.println("Enter new last name: ");
        String lastName = bf.readLine();
        System.out.println("Enter new age: ");
        int age = Integer.parseInt(bf.readLine());
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employeeDao.updateEmployee(employeeIndex - 1, employee);
    }

    private void deleteEmployee(BufferedReader bf) throws IOException {
        listEmployee();
        System.out.println("Enter the index of the employee: ");
        int index = Integer.parseInt(bf.readLine());
        employeeDao.deleteEmployee(index - 1);
    }

    private void findEmployeeById(BufferedReader bf) throws IOException {
        System.out.println("Please enter the id: ");
        String id = bf.readLine();
        Employee employee = employeeDao.findEmployeeById(id);
        System.out.println("Employee = " + employee);
    }

    private void findAllEmployee() {
        ArrayList<Employee> employees = employeeDao.findAllEmployee();
        System.out.println("Employee: ");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    private void createSpecialization(BufferedReader bf) throws IOException {
        System.out.println("Please enter the name: ");
        String name = bf.readLine();
        Specialization specialization = new Specialization();
        specialization.setName(name);
        specializationDao.createSpecialization(specialization);
    }

    private void updateSpecialization(BufferedReader bf) throws IOException {
        listSpecialization();
        System.out.println("Please enter the index: ");
        int specializationIndex = Integer.parseInt(bf.readLine());
        System.out.println("Please enter new specialization name: ");
        String name = bf.readLine();
        Specialization specialization = new Specialization();
        specialization.setName(name);
        specializationDao.updateSpecialization(specializationIndex - 1, specialization);
    }

    private void deleteSpecialization(BufferedReader bf) throws IOException {
        listSpecialization();
        System.out.println("Enter the index of the specialization: ");
        int index = Integer.parseInt(bf.readLine());
        specializationDao.deleteSpecialization(index - 1);
    }

    private void findSpecializationById(BufferedReader bf) throws IOException {
        System.out.println("Please enter the id: ");
        String id = bf.readLine();
        Specialization specialization = specializationDao.findSpecializationById(id);
        System.out.println("Specialization = " + specialization);
    }

    private void findAllSpecialization() {
        ArrayList<Specialization> specializations = specializationDao.findAllSpecialization();
        System.out.println("Specialization: ");
        for (Specialization specialization : specializations) {
            if (specialization != null) {
                System.out.println(specialization);
            }
        }
    }

    private void attachEmployeeToSpecialization(BufferedReader bf) throws IOException {
        System.out.println("Please enter the employee id: ");
        String employeeId = bf.readLine();
        System.out.println("Please enter the specialization id: ");
        String specializationId = bf.readLine();
        relationDao.addEmployeeToSpecialization(employeeId, specializationId);
    }

    private void findAllEmployeeBySpecialization(BufferedReader bf) throws IOException {
        System.out.println("Please enter employee id: ");
        String id = bf.readLine();
        ArrayList<Employee> employees = relationDao.findAllEmployeeBySpecialization(id);
        System.out.println("Specialization = " + specializationDao.findSpecializationById(id));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private void findAllSpecializationByEmployee(BufferedReader bf) throws IOException {
        System.out.println("Please enter specialization id: ");
        String id = bf.readLine();
        ArrayList<Specialization> specializations = relationDao.findAllSpecializationByEmployee(id);
        System.out.println("Employee = " + employeeDao.findEmployeeById(id));
        for (Specialization specialization : specializations) {
            System.out.println(specialization);
        }
    }


}
