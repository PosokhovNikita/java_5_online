package ua.com.a_level;
import ua.com.a_level.test.Message;

public class Hello {
    public static void main(String[] args) {
//        ua.com.a_level.test.Message message = new ua.com.a_level.test.Message();
//        can do import, but if you have 2 classes with same names you must write full way to file
        Message message = new Message();
        message.printMessage("Hello, A-Level!");
    }
}
//jar cvfm build/jar/hello.jar manifest/MANIFEST.MF -C build/classes .  - for create .jar
//java -jar build/jar/hello.jar - for start programm