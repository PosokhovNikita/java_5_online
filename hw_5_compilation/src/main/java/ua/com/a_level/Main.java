package ua.com.a_level;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<String, Integer>();
        Dictionary<String, Integer> dictionary2 = new Dictionary<String, Integer>();

        //1) Добавлять элементы в словарь
        dictionary.put("one", 11);
        dictionary.put("two", 22);
        dictionary.put("three", 33);

        //2) Получать размер словаря
        System.out.print("1)");
        System.out.println("\tSize of dictionary: " + dictionary.size());
        System.out.println();

        //3) Проверять, есть ли ключ в словаре
        System.out.print("2)");
        System.out.println("\tContains key 'two': " + dictionary.containsKey("two"));
        System.out.println();

        //4) Проверять, есть ли значение в словаре
        System.out.print("3)");
        System.out.println("\tContains value 4: " + dictionary.containsValue(4));
        System.out.println();

        //5) Получать значение по ключу
        System.out.print("4)");
        System.out.println("\tValue for key 'one': " + dictionary.get("one"));
        System.out.println("\tValue for key 'two': " + dictionary.get("two"));
        System.out.println();

        //6) Удалять элемент из словаря
        dictionary.remove("two");

        //7) Положить все ключи словаря в другой
        dictionary2.putAll(dictionary);
        System.out.print("5)");
        System.out.println("\tdictionary = " + dictionary);
        System.out.println("\tdictionary2 = " + dictionary2);
        System.out.println();

        //8) Выводить все значения словаря
        Collection<Integer> values = dictionary.values();
        System.out.print("6)");
        for (Integer value : values) {
            System.out.println("\tValue: " + value);
        }
        System.out.println();
        //9) Очистить словарь и проверить пустой ли он
        dictionary.clear();
        System.out.print("7)");
        System.out.println("\tdictionary = " + dictionary);
        System.out.println("\tDictionary is empty: " + dictionary.isEmpty());
        System.out.println();

        //10) Положить заново
        dictionary.put("one", 11);
        dictionary.put("two", 22);
        dictionary.put("three", 33);
        System.out.print("8)");
        System.out.println("\tdictionary = " + dictionary);
        System.out.println();

        //11) Пустой ли он
        System.out.print("9)");
        System.out.println("\tDictionary is empty: " + dictionary.isEmpty());
        System.out.println("\tDictionary 2 is empty: " +dictionary2.isEmpty());

    }
}