package ua.com.a_level.controller;

import ua.com.a_level.service.HelperService;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelperController {
    HelperService helperService = new HelperService();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello! It's my first File Helper!");
        String str;
        menu();
        while ((str = bf.readLine()) != null) {
            choice(bf, str);
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("====================================");
        System.out.println("|             MENU                 |");
        System.out.println("====================================");
        System.out.println("| 1. Add Directory                 |");
        System.out.println("| 2. Add File in directory         |");
        System.out.println("| 3. List files in directory       |");
        System.out.println("| 4. Delete File or Directory      |");
        System.out.println("| 5. Move file among directories   |");
        System.out.println("| 6. Find File in directory        |");
        System.out.println("| 7. Find Text in file             |");
        System.out.println("| 0. Exit                          |");
        System.out.println("====================================");
        System.out.println("Go to the directory in terminal where you " +
                           "want to create/delete/move/find. Or follow the prompts!");
        System.out.println();
    }

    private void choice(BufferedReader bf, String str) throws IOException {
        switch (str) {
            case "1" -> addDir(bf);
            case "2" -> addFile(bf);
            case "3" -> listFile(bf);
            case "4" -> deleteFileOrDir(bf);
            case "5" -> moveFileOrDir(bf);
            case "6" -> fileSearch(bf);
            case "7" -> textSearch(bf);
            case "0" -> exit();
        }
        menu();
    }

    private void addDir(BufferedReader bf) throws IOException {
        System.out.println("Specify the location where you want to create the directory throw '/': ");
        System.out.println("For example: /User/macBookAir/IdeaProjects/java_5_online/...");
        System.out.println("Where '...' - is your directory name");
        String dirNew = bf.readLine();
        helperService.createDirectory(dirNew);
    }

    private void addFile(BufferedReader bf) throws IOException {
        System.out.println("Specify the location where you want to create the file throw '/':");
        System.out.println("For example: /User/macBookAir/IdeaProjects/java_5_online/dirTest/...");
        System.out.println("Where '...' - is your file name");
        String fileNew = bf.readLine();
        helperService.createFile(fileNew);
    }

    private void listFile(BufferedReader bf) throws IOException {
        System.out.println("Enter name of Directory:");
        File file = new File(bf.readLine());
        helperService.lists(String.valueOf(file));
    }

    private void deleteFileOrDir(BufferedReader bf) throws IOException {
        System.out.println("Specify the location where you want to delete the directory or file throw '/':");
        System.out.println("For example: /User/macBookAir/IdeaProjects/java_5_online/dirTest/...");
        System.out.println("Where '...' - is your directory or file name");
        String delete = bf.readLine();
        helperService.deleteFile(delete);
    }

    private void moveFileOrDir(BufferedReader bf) throws IOException {
        System.out.println("Specify the location from you want to move the directory:");
        File directory = new File(bf.readLine());
        System.out.println("Enter file name:");
        File file = new File(directory, bf.readLine());
        System.out.println("Specify the location where you want to move the directory:");
        File directoryNew = new File(bf.readLine());
        file.renameTo(new File(directoryNew, file.getName()));
        System.out.println("File was moved to directory: " + directoryNew);
    }

    private void fileSearch(BufferedReader bf) throws IOException {
        System.out.println("Specify the location where the directory is located:");
        String dir = bf.readLine();
        System.out.println("Specify the location where the file is located:");
        String file = bf.readLine();
        helperService.findFileOrDir(new File(dir), file);
    }

    private void textSearch(BufferedReader bf) throws IOException {
        System.out.println("Specify the location where the directory is located:");
        File directory = new File(bf.readLine());
        System.out.println("Enter the text which you want to find:");
        String text = bf.readLine().toLowerCase();
        helperService.findText(directory, text);
    }

    private void exit() {
        System.out.println("Good Bye!");
        System.exit(0);
    }
}
