package ua.com.a_level;

import ua.com.a_level.controller.StudentController;

import java.io.IOException;

public class MainStudent {
    public static void main(String[] args) throws IOException {
        System.out.println("CRUD - Create-Read-Update-Delete!");
        StudentController studentController = new StudentController();
        studentController.start();
    }
}
