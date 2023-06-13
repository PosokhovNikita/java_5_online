package ua.com.a_level.controller;

import ua.com.a_level.dao.EmployeeDao;
import ua.com.a_level.dao.SpecializationDao;
import ua.com.a_level.dao.impl.EmpDaoImp;
import ua.com.a_level.dao.impl.SpecializationDaoImpl;
import ua.com.a_level.dto.SpecializationDto;
import ua.com.a_level.entity.Employee;
import ua.com.a_level.entity.Specialization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

public class Controller {

    private final EmployeeDao employeeDao = new EmpDaoImp();
    private final SpecializationDao specializationDao = new SpecializationDaoImpl();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello! It's crud app with data base!");
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
        System.out.println("| 11. Attach Employee To Specialization     |");
        System.out.println("| 12. Detach Employee from Specialization   |");
        System.out.println("| 13. Find Employee in Specialization by    |");
        System.out.println("| first/last name                           |");
        System.out.println("| 14. Specialization rating                 |");
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
            case "11" -> attachEmployeeToSpecialization(bf);
            case "12" -> detachEmployeeFromSpecialization(bf);
            case "13" -> findEmployeeInSpecializationByFirstOrLastName(bf);
            case "14" -> ratingSpecialization();
            case "0" -> exit();
        }
        menu();
    }

    private void createSpecialization(BufferedReader bf) throws IOException {
        System.out.println("Enter name of specialization: ");
        String title = bf.readLine();
        Specialization specialization = new Specialization();
        specialization.setTitle(title);
        specializationDao.create(specialization);
        System.out.println("Successfully!");
    }

    private void updateSpecialization(BufferedReader bf) throws IOException {
        System.out.println("Enter ID Specialization: ");
        Long specializationId = Long.valueOf(bf.readLine());
        System.out.println("Enter name of Specialization:");
        String title = bf.readLine();
        Specialization specialization = specializationDao.findById(specializationId);
        specialization.setTitle(title);
        specializationDao.update(specialization);
        System.out.println("Successfully!");
    }

    public void deleteSpecialization(BufferedReader bf) throws IOException {
        System.out.println("Enter ID Specialization: ");
        String id = bf.readLine();
        specializationDao.delete(Long.valueOf(id));
        System.out.println("Successfully!");
    }

    private void findSpecializationById(BufferedReader bf) throws IOException {
        System.out.println("Enter ID Specialization: ");
        Long specializationId = Long.valueOf(bf.readLine());
        Specialization specialization = specializationDao.findById(specializationId);
        if (specialization != null) {
            System.out.println("Specialization: " + specialization);
        } else {
            System.out.println("Wrong Data!");
        }
    }

    private void findAllSpecialization() {
        Collection<Specialization> specialization = specializationDao.findAll();
        System.out.println("Specialization: ");
        for (Specialization specializations : specialization) {
            if (specializations != null) {
                System.out.println(specializations);
            }
        }
    }

    private void createEmployee(BufferedReader bf) throws IOException {
        System.out.println("Enter first name: ");
        String firstName = bf.readLine();
        System.out.println("Enter last name: ");
        String lastName = bf.readLine();
        System.out.println("Enter age: ");
        String stringAge = bf.readLine();
        int age = Integer.parseInt(stringAge);
        System.out.println("Enter e-mail: ");
        String email = bf.readLine();
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setEmail(email);
        employeeDao.create(employee);
        System.out.println("Successfully!");
    }

    private void updateEmployee(BufferedReader bf) throws IOException {
        System.out.println("Enter ID Employee: ");
        Long employeeId = Long.valueOf(bf.readLine());
        System.out.println("Enter new first name: ");
        String firstName = bf.readLine();
        System.out.println("Enter new last name: ");
        String lastName = bf.readLine();
        System.out.println("Enter new age: ");
        int age = Integer.parseInt(bf.readLine());
        System.out.println("Enter new email: ");
        String email = bf.readLine();
        Employee employee = employeeDao.findById(employeeId);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setEmail(email);
        employeeDao.update(employee);
        System.out.println("Successfully!");
    }

    public void deleteEmployee(BufferedReader bf) throws IOException {
        System.out.println("Enter Employee ID: ");
        String id = bf.readLine();
        employeeDao.delete(Long.valueOf(id));
        System.out.println("Successfully!");
    }

    private void findEmployeeById(BufferedReader bf) throws IOException {
        System.out.println("Enter Employee ID: ");
        Long employeeId = Long.valueOf(bf.readLine());
        Employee employee = employeeDao.findById(employeeId);
        if (employee != null) {
            System.out.println("Employee: " + employee);
        } else {
            System.out.println("Wrong Data!");
        }
    }

    private void findAllEmployee() {
        Collection<Employee> employees = employeeDao.findAll();
        System.out.println("Employee: ");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public void attachEmployeeToSpecialization(BufferedReader bf) throws IOException {
        System.out.println("Enter ID Specialization: ");
        Long specializationId = Long.valueOf(bf.readLine());
        System.out.println("Enter ID Employee: ");
        String employeeId = bf.readLine();
        specializationDao.attachEmployeeToSpecialization(specializationId, Long.valueOf(employeeId));
        System.out.println("Employee with ID " + Long.valueOf(employeeId) +
                " attach to Specialization with ID " + specializationId);
    }

    public void detachEmployeeFromSpecialization(BufferedReader bf) throws IOException {
        System.out.println("Enter ID Specialization: ");
        Long specializationId = Long.valueOf(bf.readLine());
        System.out.println("Enter ID employee: ");
        String employeeId = bf.readLine();
        specializationDao.detachEmployeeFromSpecialization(specializationId, Long.valueOf(employeeId));
        System.out.println("Employee with ID " + Long.valueOf(employeeId) +
                " detach from Specialization with ID " + specializationId);
    }

    public void findEmployeeInSpecializationByFirstOrLastName(BufferedReader bf) throws IOException {
        System.out.println("Enter Employee first name: ");
        String firstName = bf.readLine();
        System.out.println("Enter Employee last name: ");
        String lastName = bf.readLine();
        boolean employee = employeeDao.existByFirstOrLastName(firstName, lastName);
        System.out.println(employee);
    }

    public void ratingSpecialization() {
        Collection<SpecializationDto> specializationDtos = specializationDao.findSpecializationStatistics();
        if (specializationDtos.isEmpty()) {
            System.out.println("Empty!");
        } else {
            int ratingNumber = 1;
            System.out.println("Rating specialization: ");
            for (SpecializationDto specializationDto : specializationDtos) {
                System.out.println(ratingNumber + ". " + specializationDto.toString());
                ratingNumber++;
            }
        }
    }
}
