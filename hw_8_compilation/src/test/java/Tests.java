import org.junit.Test;
import ua.com.a_level.entity.Employee;
import ua.com.a_level.entity.Relation;
import ua.com.a_level.entity.Specialization;
import ua.com.a_level.service.Service;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class Tests {
    Service service = new Service();

    @Test
    public void createSpecialization() throws IOException {
        Specialization specialization = new Specialization();
        specialization.setName("PH");
        service.createSpecialization(specialization);
        ArrayList<Specialization> specializationArrayList = service.findAllSpecialization();
        assertTrue(specializationArrayList.contains(specialization));
    }

    @Test
    public void createEmployeeTest() throws IOException {
        Employee employee = new Employee();
        employee.setFirstName("Oleg");
        employee.setLastName("228");
        employee.setAge(16);
        service.createEmployee(employee);
        ArrayList<Employee> employees = service.findAllEmployee();
        assertTrue(employees.contains(employee));
    }

    @Test
    public void addEmployeeToSpecializationTest() throws IOException {
        Specialization specialization = new Specialization();
        specialization.setName("OF");
        service.createSpecialization(specialization);
        Employee employee = new Employee();
        employee.setFirstName("NeOleg");
        employee.setLastName("322");
        employee.setAge(22);
        service.createEmployee(employee);
        service.addEmployeeToSpecialization(employee.getId(), specialization.getId());
        ArrayList<Relation> relations = service.getRelations();
        boolean isAdded = false;
        for (Relation relation : relations) {
            if (relation.getSpecialization().equals(specialization) && relation.getEmployee().equals(employee)) {
                isAdded = true;
            }
        }
        assertTrue(isAdded);
    }
}

