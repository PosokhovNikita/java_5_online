package ua.com.a_level;
import ua.com.a_level.test.Message;

public class Hello {
    public static void main(String[] args) {
//        ua.com.a_level.test.Message message = new ua.com.a_level.test.Message();
//        can do import, but if you have 2 classes with same names you must write full way to file
        Message message = new Message();
        message.printMessage("HELLO, A-LEVEL!");
    }
}
//javac -sourcepath ./src -d build/classes -cp ./library/commons-lang3-3.12.0.jar src/ua/com/a_level/Hello.java
//java -cp build/classes/:./library/commons-lang3-3.12.0.jar ua/com/a_level/Hello
// cd ./library
// jar xf commons-lang3-3.12.0.jar
// cp -rf org ../build/classes
//cd ..
//jar cvfm build/jar/hello.jar manifest/MANIFEST.MF -C build/classes .
//jar tf build/jar/hello.jar - (show .jar)
// java -jar build/jar/hello.jar - (start programm)