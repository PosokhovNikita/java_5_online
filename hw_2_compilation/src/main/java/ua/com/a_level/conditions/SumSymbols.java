package ua.com.a_level.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class SumSymbols {

    public static void enterString(BufferedReader bf) throws IOException {
        System.out.println("Enter any value to find out the amount of each character: ");
        String amountInput = bf.readLine();
        char[] chars = amountInput.toCharArray();   //Кладем наше значение в массив чаров
        Arrays.sort(chars);   //Сортировка по возрастанию
        String str = String.copyValueOf(chars);   // copyValueOf() – получение строки из массива символо
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) { //isLetter() – определяет, является ли указанное значение типа char буквой.
                System.out.println(chars[i] + " - " + (str.lastIndexOf(chars[i]) - str.indexOf(chars[i]) + 1));
                i += (str.lastIndexOf(chars[i]) - str.indexOf(chars[i]));
            }
            //indexOf - Возвращает индекс первого вхождения указанного символа в этой строке,
            // начиная поиск по указанному индексу.
        }   //lastIndexOf - Возвращает индекс в этой строке последнего вхождения указанного символа,
            // выполняя поиск в обратном направлении, начиная с указанного индекса
    }
}
