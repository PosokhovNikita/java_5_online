package ua.com.a_level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
public class WordAmount {
   public void start(){
       try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           System.out.println("Enter your text: ");
           String str = reader.readLine().toLowerCase()
                   .replaceAll("[^a-zA-Z ]", "")//удаляет все символы кроме латинских букв и пробелов из строки
//                   .replaceAll("[^а-яА-Я ]", "")//удаляет все символы кроме кириллицы и пробелов из строки
                   .trim().replaceAll("\\s+"," ");//удаляет лишние пробелы из строки

           List<String> words = Arrays.asList(str.split("\\s+"));//Создает список слов из строки

           Map<String, Long> periodicityMap = words.stream()
                   .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
           //создает мапу частоты слов, где каждому уникальному слову из списка
           //соответствует число его повторений в списке.
           //Collectors.counting())) - группирует слова по значению
           //(каждое уникальное значение становится ключом в карте),
           //а затем считает количество появлений каждого уникального значения.

           List<Map.Entry<String, Long>> sortedValues = periodicityMap.entrySet().stream()
                   .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).toList();
           //создает список, отсортированный по убыванию значений (частот слов)
           //из карты частоты слов (periodicityMap).

           long totalCount = sortedValues.stream().mapToLong(Map.Entry::getValue).sum();
           // вычисляет общее количество слов в тексте (суммирует частоты всех слов в списке sortedValues).

           System.out.println("-----------------------------------------------------------------");
           System.out.println("| Words                    | Amount   | Percentage of total     |");
           System.out.println("-----------------------------------------------------------------");

           for (Map.Entry<String, Long> entrance : sortedValues) {
               String word = entrance.getKey();//получаем слово
               Long amount = entrance.getValue();//получаем колличество
               double percent = amount * 100.0 / totalCount;//вычисляем процентное соотношение
               System.out.printf("| %-24s | %8d | %25.2f%% \n", word, amount, percent);//вывод информации
           }
           System.out.println("------------------------------------------------------------------");
           System.out.println("Total words without characters and spaces: " + totalCount);
       } catch (IOException e) {
           e.printStackTrace();//вызов метода объекта исключения e,
           // который выводит трассировку стека (stack trace) исключения
           // в стандартный поток ошибок (stderr).это вызов метода объекта
           // исключения e, который выводит трассировку стека (stack trace) исключения
           // в стандартный поток ошибок (stderr).
       }

       //% - символ, указывающий на начало форматированного аргумента
       //- - опциональный символ для выравнивания по левому краю
       //24 - минимальная ширина поля для вывода (24 символа)
       //s - тип аргумента (строка)
       //8 - минимальная ширина поля для вывода (8 символов)
       //d - тип аргумента (целое число)
       //25.2f - минимальная ширина поля для вывода (25 символов), два знака после запятой и тип аргумента (число с плавающей точкой)
       //%% - символ %, используется для экранирования символа %
   }
}