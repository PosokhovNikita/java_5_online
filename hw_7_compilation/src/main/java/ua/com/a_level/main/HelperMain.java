package ua.com.a_level.main;

import ua.com.a_level.controller.HelperController;

import java.io.IOException;

public class HelperMain {
    public static void main(String[] args) {
        HelperController helperController = new HelperController();
        try {
            helperController.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}