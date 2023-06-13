package ua.com.a_level.entity;

import java.io.Serializable;

public class Specialization extends BaseEntitySpecialization implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
