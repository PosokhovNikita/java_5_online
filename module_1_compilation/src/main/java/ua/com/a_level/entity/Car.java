package ua.com.a_level.entity;

import java.util.HashSet;
import java.util.Set;

public class Car extends BaseEntity {
    private String brandCar;
    private String ownerCarName;
    private String serialNumber;
    private Set<String> idGarage = new HashSet<>();

    public String getCarBrand() {
        return brandCar;
    }

    public void setCarBrand(String carBrand) {
        this.brandCar = carBrand;
    }

    public String getCarOwnerName() {
        return ownerCarName;
    }

    public void setCarOwnerName(String carOwnerName) {
        this.ownerCarName = carOwnerName;
    }

    public String getCarSerialNumber() {
        return serialNumber;
    }

    public void setCarSerialNumber(String carSerialNumber) {
        this.serialNumber = carSerialNumber;
    }

    public Set<String> getGarageId() {
        return idGarage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Brand Car = '" + brandCar + '\'' +
                ", Car Owner Name = '" + ownerCarName + '\'' +
                ", Car Serial Number = '" + serialNumber + '\'' +
                ", Garage Id = " + idGarage +
                ", ID = " + getId() +
                "} " ;
    }
}
