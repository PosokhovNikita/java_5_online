package ua.com.a_level.entity;

import java.util.HashSet;
import java.util.Set;

public class Garage extends BaseEntity {
    private String address;
    private Set<String> carId = new HashSet<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<String> getCarIdList() {
        return carId;
    }

    public String toString() {
        return "Garage{" +
                "Address = '" + address + '\'' +
                ", Car ID = " + carId +
                ", ID = " + getId() +
                '}';
    }
}
