package ua.com.a_level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to the app, for finding the shortest path!");
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            menuItems(select);
        }
    }

    public void menu() {
        System.out.println();
        System.out.println("====================================");
        System.out.println("|             MENU                 |");
        System.out.println("====================================");
        System.out.println("| 1. To start with template file   |");
        System.out.println("| 2. To start with input file      |");
        System.out.println("| 0. Exit                          |");
        System.out.println("====================================");
    }

    public void menuItems(String select) throws IOException {
        switch (select) {
            case "1" -> handleTemplateFile();
            case "2" -> handleInputFile();
            case "0" -> exit();
        }
        menu();
    }

    private void handleTemplateFile() throws IOException {
        FileProcessor fileHandler = new FileProcessor();
        fileHandler.inputFileChanger("1");
    }

    private void handleInputFile() throws IOException {
        FileProcessor fileHandler = new FileProcessor();
        fileHandler.inputFileChanger("2");
    }

    public void exit() {
        System.out.println("Good Bye!");
        System.exit(0);
    }
}
