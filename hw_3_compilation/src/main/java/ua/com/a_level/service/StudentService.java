package ua.com.a_level.service;

import ua.com.a_level.entity.Student;
import java.util.UUID;

//service class
public class StudentService {
    private Student[]students = new Student[10];
    private int studentSum;

    public void create(Student student){
        //Эта функция создает студента и проверяет, имеется ли какой-либо свободный элемент для добавления студента;
        //В случае да - студент добавляется в свободный элемент.
        //В любом другом случае студент добавляется в конец массива.
        //Так же дает ему уникальный идентификатор, удаляет значения null, если нужно - увеличивает размер массива.
        student.setId(generateId());
        nullsCheckDelete();
        increaseInSize();
        int checking = checkingForNulls();
        if (checking >= 0) {
            students[checking] = student;
        } else {
            students[studentSum] = student;
        }
        studentSum ++;
    }
    public void update(Student student){
        //Эта функция находит студента по id и в контроллере презадает ему поля для изменения
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
        // Эта функция по id находит студента и превращает его в null
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
        //Эта функция находит по id студента и возвращает его, либо же не возвращает ничего
        for (Student student : students) {
            if (student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }

    public Student[] findAll(){
        //Эта функция возвращает всех студентов из массива
        return students;
    }
    private String generateId(){
        //Эта функция генерирует уникальный id и во избежание совпадения проверяет и перезапускает функцию
        String id = UUID.randomUUID().toString();
        for (Student student : students) {
            if(student!= null && student.getId().equals(id)){
                return generateId();
            }//Рекурсия - возвращает сама себя
        }
        return id;
    }
    private int checkingForNulls() {
        //Эта функция ищет значения null в массиве. Если найдено значение null,
        // то функция возвращает индекс этого значения. В противном случае она возвращает -1.
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                return i;
            }
        }
        return -1;
    }
    private void nullsDelete(){
        //Эта функция очищает массив от значений null. Она проверяет каждый элемент массива и
        // составляет новый массив, не содержащий значений null. Текущий массив students заменяется на новый массив.
        int size = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null){
                size++;
            }
        }
        Student[] students2 = new Student[size];
        int studentCounter = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null){
                students2[studentCounter] = students[i];
                studentCounter++;
            }
        }
        this.students = students2;
    }
    private void nullsCheckDelete(){
        //Эта функция проверяет есть ли пустые места в массиве. Если длинна больше, то вызывает nullsDelete
        if (studentSum == 0){
            System.out.println(studentSum);
        } else if (students.length/studentSum == 10){
            nullsDelete();
        }
    }

    private void increaseInSize() {
        //Эта функция увеличивает размер массива, если количество элементов равно длине массива.
        //Она создает новый массив, который будет иметь длину в два раза больше текущего массива,
        //а затем копирует все элементы из старого массива в новый
        if (studentSum == students.length) {
            Student[] students3 = new Student [(students.length * 2) + 1];
            for (int i = 0; i < students.length; i++) {
                students3[i] = students[i];
            }
            this.students = students3;
        }
    }
}
