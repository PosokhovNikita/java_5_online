package ua.com.a_level;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}