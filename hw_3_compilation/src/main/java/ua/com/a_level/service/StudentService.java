package ua.com.a_level.service;

import ua.com.a_level.entity.Student;
import java.util.UUID;

//service class
public class StudentService {
    private Student[]students = new Student[11];
    public void create(Student student){
        student.setId(generateId());
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null){
                students[i] = student;
                break;
            }
        }
    }

    public void update(Student student){
        for (int i = 0; i < students.length; i++) {
            try {
                if (students[i].getId().equals(student.getId())) {
                    students[i] = student;
                }
            }
            catch (Exception exception) {
                i++;
            }
        }
    }

    public Student delete(String id){
        for (int i = 0; i < students.length; i++) {
            try {
                if(students[i].getId().equals(id)){
                    students[i] = null;
                }
            }
            catch (Exception exception){
                i++;
            }
        }
        return null;
    }

    public Student findById(String id){
        for (Student student : students) {
            if (student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    public Student[] findAll(){
        return students;
    }
    private String generateId(){
        String id = UUID.randomUUID().toString();
        for (Student student : students) {
            if(student!= null && student.getId().equals(id)){
                return generateId();
            }//Recursive function - return itself;
        }
        return id;
    }
}
