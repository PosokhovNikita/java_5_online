package ua.com.a_level.entity;

import java.io.Serializable;

public class Relation implements Serializable {

    private Employee employee;
    private Specialization specialization;

    public Employee getEmployee() {
        return employee;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public Relation(Employee employee, Specialization specialization) {
        this.employee = employee;
        this.specialization = specialization;
    }
}
