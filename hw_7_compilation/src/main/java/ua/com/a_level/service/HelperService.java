package ua.com.a_level.service;

import java.io.File;
import java.io.IOException;

public class HelperService {
    public void createDirectory(String directoryName) {
        File dirs = new File(directoryName);
        dirs.getAbsolutePath();
        String path = dirs.getAbsolutePath();
        System.out.println(path);
        dirs.mkdirs();
    }

    public void createFile(String fileName) throws IOException {
        File file = new File(fileName);
        file.getAbsolutePath();
        String path = file.getAbsolutePath();
        System.out.println(path);
        file.createNewFile();
    }

    public void lists(String fileName) {
        File file = new File(fileName);
        file.getAbsolutePath();
        String path = file.getAbsolutePath();
        System.out.println(path);
        File[] files = file.listFiles();
        for (File fileNew : files) {
            System.out.println(fileNew);
        }
    }

    public void deleteFile(String fileName) {
        File file = new File(fileName);
        file.delete();
        System.out.println("File deleted from:");
        file.getAbsolutePath();
        String path = file.getAbsolutePath();
        System.out.println(path);
    }

    public void findFileOrDir(File dir, String findFile) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equalsIgnoreCase(findFile)) {
                        System.out.println(file.getAbsolutePath());
                        return;
                    } else {
                        findFileOrDir(file, findFile);
                    }
                }
            }
        }
    }

    public static void findText(File file, String findText) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    findText(file1, findText);
                }
            }
        }
    }
}
