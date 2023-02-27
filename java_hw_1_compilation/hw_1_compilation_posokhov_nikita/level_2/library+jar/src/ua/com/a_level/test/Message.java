package ua.com.a_level.test;

import org.apache.commons.lang3.StringUtils;

public class Message {
    public void printMessage(String message) {
        System.out.println("message  = " + message);
        System.out.println("message  = " + StringUtils.lowerCase(message));

    }

}
