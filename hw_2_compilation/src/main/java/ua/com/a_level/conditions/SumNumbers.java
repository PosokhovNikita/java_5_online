package ua.com.a_level.conditions;

import java.io.BufferedReader;
import java.io.IOException;

public class SumNumbers {

    public static void enterString(BufferedReader bf) throws IOException {
        System.out.println("Enter any value with numbers to find out their sum: ");
        String stringInput = bf.readLine();
        char[] chars = stringInput.toCharArray();   //Кладем введенное значение в массив чаров
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            int symbol = Character.digit(chars[i], 10);//В ascii первые 10 символов цифры (0 - 9)
            //Character - оболочкка char для использования объектов вместо примитивных типов данных.
            //Возвращает числовое значение указанного символа (кодовая точка Unicode) в указанной системе счисления.
            if (symbol > 0 && symbol < 10) {
                sum = sum + symbol;
            }
        }
        System.out.println("The sum of all the numbers in your value: " + sum);
    }
}
