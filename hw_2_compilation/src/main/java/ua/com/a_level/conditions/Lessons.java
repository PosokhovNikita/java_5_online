package ua.com.a_level.conditions;

import java.io.BufferedReader;
import java.io.IOException;

public class Lessons {

    public static void enterString(BufferedReader bf) throws IOException {
        System.out.println("Enter the number of lesson from 1 to 10: ");
        int lessonInput = Integer.parseInt(bf.readLine());
        int     startLesson = 9 * 60,
                littleRecreation = 5,
                bigRecreation = 15,
                lesson = 45;
            int calculationTime = startLesson + lessonInput * lesson;
            calculationTime += (lessonInput) / 2 * littleRecreation;
            calculationTime += (lessonInput - 1) / 2 * bigRecreation;
            System.out.println("Lesson " + lessonInput  + " end at " +
                    (calculationTime / 60 + ":" + calculationTime % 60));
    }
}   //parseInt - Анализирует строковый аргумент как целое число без знака в системе счисления,
    // указанной вторым аргументом