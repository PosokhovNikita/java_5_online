package ua.com.a_level.main;

import ua.com.a_level.controller.GarageController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GarageController garageController = new GarageController();
        garageController.start();
    }
}
