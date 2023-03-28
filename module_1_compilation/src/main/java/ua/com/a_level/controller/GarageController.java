package ua.com.a_level.controller;

import ua.com.a_level.entity.Car;
import ua.com.a_level.entity.Garage;
import ua.com.a_level.service.GarageService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class GarageController {
    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello, it`s my second CRUD program!");
        System.out.println("Select options from menu");
        String str;
        menu();
        while ((str = bf.readLine()) != null) {
            crud(bf, str);
        }
    }
    private void menu() {
        System.out.println();
        System.out.println("====================================");
        System.out.println("|             MENU                 |");
        System.out.println("====================================");
        System.out.println("| 1. Create car                    |");
        System.out.println("| 2. Find car                      |");
        System.out.println("| 3. Show all cars                 |");
        System.out.println("| 4. Update car owner              |");
        System.out.println("| 5. Delete car                    |");
        System.out.println("| 6. Create garage                 |");
        System.out.println("| 7. Find garage                   |");
        System.out.println("| 8. Show all garages              |");
        System.out.println("| 9. Put car to garage             |");
        System.out.println("| 10. Change garage for car        |");
        System.out.println("| 11. Delete car from garage       |");
        System.out.println("| 12. Delete garage                |");
        System.out.println("| 13. Find cars by garage          |");
        System.out.println("| 0. Exit                          |");
        System.out.println("====================================");
        System.out.println();
    }
    private void crud(BufferedReader bf, String str) throws IOException {
        switch (str) {
            case "1" -> createCar(bf);
            case "2" -> findByIdCar(bf);
            case "3" -> findAllCars();
            case "4" -> updateCar(bf);
            case "5" -> carDelete(bf);
            case "6" -> createGarage(bf);
            case "7" -> findByIdGarage(bf);
            case "8" -> findAllGarages();
            case "9" -> putCarToGarage(bf);
            case "10" -> newGarageForCar(bf);
            case "11" -> deleteCarFromGarages(bf);
            case "12" -> garageDelete(bf);
            case "13" -> findCarByGarage(bf);
            case "0" -> exit();
        }
        menu();
    }
    private void createCar(BufferedReader bf) throws IOException {
        System.out.println("Create car:");
        Car car = new Car();
        confirmCarBrand(bf, car);
        confirmCarOwnerName(bf, car);
        confirmSerialNumber(bf, car);
        GarageService.addCar(car);
        System.out.println("Car create successfully!");
    }
    private void createGarage(BufferedReader bf) throws IOException {
        System.out.println("Create garage");
        Garage garage = new Garage();
        confirmGarageAddress(bf, garage);
        GarageService.addGarage(garage);
        System.out.println("Garage create successfully!");
    }
    private void findByIdCar(BufferedReader bf) throws IOException {
        System.out.println("Find car by id");
        System.out.println("Please enter id:");
        String id = bf.readLine();
        Car car = GarageService.getCar(id);
        if (car == null) {
            System.out.println("Nothing to find!");
        } else {
            System.out.println("Car = " + car);
        }
    }
    private void findByIdGarage(BufferedReader bf) throws IOException {
        System.out.println("Find garage by id");
        System.out.println("Please enter id:");
        String id = bf.readLine();
        Garage garage = GarageService.getGarage(id);
        if (garage == null) {
            System.out.println("Nothing to find");
        } else {
            System.out.println("Garage = " + garage);
        }
    }
    private void putCarToGarage(BufferedReader bf) throws IOException {
        System.out.println("Put car to garage");
        System.out.println("Please enter garage id:");
        String garageId = bf.readLine();
        System.out.println("Please enter car id:");
        String carId = bf.readLine();
        if (GarageService.getCar(carId) != null && GarageService.getGarage(garageId) != null) {
            GarageService.addCarToGarage(carId, garageId);
            System.out.println("Added successfully!");
        } else {
            System.out.println("This id was not found");
        }
    }
    private void findCarByGarage(BufferedReader bf) throws IOException {
        System.out.println("Find all cars by garage");
        System.out.println("Please enter garage id");
        String garageId = bf.readLine();
        List<Car> cars = GarageService.findByGarage(garageId);
        if (cars.isEmpty()) {
            System.out.println("Nothing to find!");
        } else {
            cars.forEach(System.out::println);
        }
    }
    private void findAllCars() {
        System.out.println("Find all cars");
        List<Car> cars = GarageService.allCars();
        if (cars.isEmpty()) {
            System.out.println("Nothing to find!");
        } else {
            cars.forEach(System.out::println);
        }
    }
    private void findAllGarages() {
        System.out.println("Find all garages");
        List<Garage> garages = GarageService.allGarages();
        if (garages.isEmpty()) {
            System.out.println("Nothing to find!");
        } else {
            garages.forEach(System.out::println);
        }
    }
    private void updateCar(BufferedReader bf) throws IOException {
        System.out.println("Update car owner");
        System.out.println("Please enter car id which you want to update");
        String carId = bf.readLine();
        System.out.println("Please enter new car owner name");
        String carOwnerName = bf.readLine();
        if (GarageService.getCar(carId) != null) {
            if (carOwnerName.matches("^[a-zA-Z]{2,25}$")) {
                GarageService.updateCar(carId, carOwnerName);
                System.out.println("Updated successfully!");
            } else System.out.println("Wrong Data! Use letters!");
        } else System.out.println("This id was not found");
    }
    private void carDelete(BufferedReader bf) throws IOException {
        System.out.println("Delete car");
        System.out.println("Please enter car id which you want to delete");
        String carId = bf.readLine();
        if (GarageService.getCar(carId) != null) {
            GarageService.deleteCar(carId);
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("This id was not found");
        }
    }
    private void garageDelete(BufferedReader bf) throws IOException {
        System.out.println("Delete garage");
        System.out.println("Please enter garage id which you want to delete");
        String garageId = bf.readLine();
        if (GarageService.getGarage(garageId) != null) {
            GarageService.deleteGarage(garageId);
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("This id was not found");
        }
    }
    private void deleteCarFromGarages(BufferedReader bf) throws IOException {
        System.out.println("Delete car from garage");
        System.out.println("Please enter car id car which you want to delete");
        String carId = bf.readLine();
        System.out.println("Please enter garage id from which you want to delete");
        String garageId = bf.readLine();
        if (GarageService.getCar(carId) != null && GarageService.getGarage(garageId) != null) {
            GarageService.deleteCarFromGarage(carId, garageId);
            System.out.println("Deleted successfully!");
        } else {
            System.out.println("This id was not found");
        }
    }
    private void confirmCarBrand(BufferedReader bf, Car car) throws IOException {
        String carBrand;
        while (true) {
            System.out.println("Please enter car brand");
            carBrand = bf.readLine();
            if (carBrand.matches("^[a-zA-Z]{2,25}$")) {
                car.setCarBrand(carBrand);
                break;
            } else {
                System.out.println("Wrong data! Use only letters ");
            }
        }
    }
    private void confirmCarOwnerName(BufferedReader bf, Car car) throws IOException {
        String carOwnerName;
        while (true) {
            System.out.println("Please enter car owner name");
            carOwnerName = bf.readLine();
            if (carOwnerName.matches("^[a-zA-Z]{2,25}$")) {
                car.setCarOwnerName(carOwnerName);
                break;
            } else {
                System.out.println("Wrong data! Use only letters ");
            }
        }
    }
    private void confirmSerialNumber(BufferedReader bf, Car car) throws IOException {
        String serialNumber;
        while (true) {
            System.out.println("Please enter car serial number: format <XX1234XX, XX12345XX> ");
            serialNumber = bf.readLine();
            if (serialNumber.matches("^[A-Z]{2}[0-9]{4,5}[A-Z]{2}$")) {
                car.setCarSerialNumber(serialNumber);
                break;
            } else {
                System.out.println("Wrong data!Use only letters and numbers");
            }
        }

    }
    private void confirmGarageAddress(BufferedReader bf, Garage garage) throws IOException {
        String garageAddress;
        while (true) {
            System.out.println("Please enter garage address");
            garageAddress = bf.readLine();
            if (garageAddress.matches("^[a-zA-Z0-9]{2,25}$")) {
                garage.setAddress(garageAddress);
                break;
            } else {
                System.out.println("Wrong data! Use only letters and numbers");
            }
        }
    }
    private void newGarageForCar(BufferedReader bf) throws IOException {
        System.out.println("Change garage for car");
        System.out.println("Enter car id which you want to replace");
        String carNum = bf.readLine();
        System.out.println("Enter actual garage id ");
        String oldNum = bf.readLine();
        System.out.println("Enter new garage id in which you want to replace");
        String garageNum = bf.readLine();
        if (GarageService.getCar(carNum) != null && GarageService.getGarage(oldNum) != null && GarageService.getGarage(garageNum) != null) {
            GarageService.deleteCarFromGarage(carNum, oldNum);
            GarageService.addCarToGarage(carNum, garageNum);
            System.out.println("Replaced successfully!");
        } else {
            System.out.println("This id was not found");
        }
    }
    private void exit() {
        System.out.println("Good Bye!");
        System.exit(0);

    }
}
