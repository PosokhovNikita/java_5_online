package ua.com.a_level.menu;

import ua.com.a_level.conditions.Lessons;
import ua.com.a_level.conditions.SumNumbers;
import ua.com.a_level.conditions.SumSymbols;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Menu {
    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Select from list: ");
        String str;
        list();
        while ((str = bf.readLine()) != null) {
            operationList(bf, str);
        }
    }
    private void list() {
        System.out.println("If you want to know the sum of number in your string - ENTER 1");
        System.out.println("If you want to know the sum of each character in the string - ENTER 2");
        System.out.println("If you want to know what time the lesson ends - ENTER 3");
        System.out.println("If you want to EXIT - ENTER 0");
    }
    private void exit() {
        System.out.println("Good Bye!");
        System.exit(0);
    }
    public void operationList(BufferedReader bf, String choose) throws IOException {
        switch (choose) {
            case "1" -> SumNumbers.enterString(bf);
            case "2" -> SumSymbols.enterString(bf);
            case "3" -> Lessons.enterString(bf);
            case "0" -> exit();
        }
        list();
    }
}
