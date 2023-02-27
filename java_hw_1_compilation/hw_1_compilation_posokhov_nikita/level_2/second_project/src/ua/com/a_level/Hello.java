package ua.com.a_level;
import ua.com.a_level.test.Message;

public class Hello {
    public static void main(String[] args) {
//        ua.com.a_level.test.Message message = new ua.com.a_level.test.Message();
        Message message = new Message();
        message.printMessage("Hello, A-Level!");
    }
}

//javac -sourcepath ./src -d build/classes/ ./src/ua/com/a_level/Hello.java
//-cp build/classes ua.com.a_level.Hello