package ua.com.a_level.controller;

import ua.com.a_level.service.Methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello! Choose from list: ");
        String s;
        list();
        while ((s = bf.readLine()) != null){
        operationList(bf,s);
        list();
        }
    }
    private void list(){
        System.out.println("If you want to usual reverse ENTER -> 1");
        System.out.println("If you want to substring reverse ENTER -> 2");
        System.out.println("If you want to substring reverse with index ENTER -> 3");
        System.out.println("If you want to exit ENTER -> 0");
    }
    private void operationList(BufferedReader bf, String s) throws IOException {
        switch (s){
            case "1" -> ordinaryReverse(bf);
            case "2" -> substringReverse(bf);
            case "3" -> substringReverseWithIndex(bf);
            case "0" -> exit();
        }
    }
    private void ordinaryReverse(BufferedReader bf) throws IOException {
        System.out.println("Enter your line: ");
        System.out.println(Methods.reverse(bf.readLine()));
    }
    private void substringReverse(BufferedReader bf)throws IOException{
        System.out.println("Enter your line: ");
        String user = bf.readLine();
        System.out.println("Enter substring in you line to reverse: ");
        String sub = bf.readLine();
        System.out.println(Methods.reverse(user,sub));
    }
    private void substringReverseWithIndex(BufferedReader bf)throws IOException{
        System.out.println("Enter your line: ");
        String user = bf.readLine();
        System.out.println("Enter first index: ");
        int firstIndex = Integer.parseInt(bf.readLine());
        System.out.println("Enter second index: ");
        int secondIndex = Integer.parseInt(bf.readLine());
        System.out.println(Methods.reverse(user,firstIndex,secondIndex));
    }
    private void exit() {
        System.out.println("Good Bye!");
        System.exit(0);
    }
}
