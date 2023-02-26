package ua.com.a_level.controller;

import ua.com.a_level.entity.Student;
import ua.com.a_level.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//service class
public class StudentController {

     private StudentService studentService = new StudentService();

    public void start() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\tHello! It is my first CRUD program!");
        System.out.println("\tSelect options:");
        String choose;
        menu();
        while ((choose = bf.readLine()) != null){
            crud(bf,choose);
        }
    }
    private void exit() {
        System.out.println("Good Bye!");
        System.exit(0);
    }
    private void crud(BufferedReader bf, String choose) throws IOException {
        switch (choose){
            case "1" -> create(bf);
            case "2" -> update(bf);
            case "3" -> delete(bf);
            case "4" -> findById(bf);
            case "5" -> findAll();
            case "0" -> exit();
        }
        menu();
    }
    private void menu(){
        System.out.println();
        System.out.println("\tIf you want to create a student, please enter 1");
        System.out.println("\tIf you want to update a student, please enter 2");
        System.out.println("\tIf you want to delete a student, please enter 3");
        System.out.println("\tIf you want to find a student, please enter 4");
        System.out.println("\tIf you want to find all student, please enter 5");
        System.out.println("\tIf you want to exit from program, please enter 0");
    }
    private void create(BufferedReader bf) throws IOException {
        System.out.println("Please enter the first name:");
        String firstName = bf.readLine();
        System.out.println("Please enter the last name:");
        String lastName = bf.readLine();
        System.out.println("Please enter the phone number:");
        String phone = bf.readLine();
        System.out.println("Please enter the e-mail:");
        String email = bf.readLine();
        System.out.println("Please enter the age:");
        String stringAge = bf.readLine();
        int age = Integer.parseInt(stringAge);
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setPhone(phone);
        student.setEmail(email);
        student.setAge(age);
        studentService.create(student);
    }
    private void update(BufferedReader bf) throws IOException{
        System.out.println("Enter id");
        String id = bf.readLine();
        System.out.println("Please enter the new first name:");
        String firstName = bf.readLine();
        System.out.println("Please enter the new last name:");
        String lastName = bf.readLine();
        System.out.println("Please enter the  new phone number:");
        String phone = bf.readLine();
        System.out.println("Please enter the new e-mail:");
        String email = bf.readLine();
        System.out.println("Please enter the new age:");
        String stringAge = bf.readLine();
        int age = Integer.parseInt(stringAge);
        Student student = studentService.findById(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setPhone(phone);
        student.setEmail(email);
        student.setAge(age);
        studentService.update(student);
    }

    private void delete(BufferedReader bf) throws IOException{
        System.out.println("Please enter ID student: ");
        String id = bf.readLine();
        Student student = studentService.delete(id);
        System.out.println("Student was removed!");

    }

    private void findById(BufferedReader bf) throws IOException {
        System.out.println("Please enter the ID: ");
        String id = bf.readLine();
        Student student = studentService.findById(id);
        System.out.println("student = " + student);
    }
    private void findAll() {
        Student[] students = studentService.findAll();
        for (Student student : students) {
            System.out.println("student = " + student);
            
        }
    }
}
