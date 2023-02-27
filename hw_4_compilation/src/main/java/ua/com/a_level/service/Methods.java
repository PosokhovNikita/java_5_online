package ua.com.a_level.service;

public class Methods {
    public static String reverse(String src) {
        //Этот метод позволяет перевернуть строку оставляя слова на месте, заменяя символы в словах в обратном порядке
        String[] strings = src.trim().split(" ");
        StringBuilder reverseString = new StringBuilder();
        for (String string : strings) {
            String[] str = string.split("");
            for (int i = str.length - 1; i >= 0; i--) {
                reverseString.append(str[i]);
            }
            reverseString.append(" ");
        }
        return reverseString.toString();
    }

    //Метод trim() позволяет удалить пробелы в начале и конце строки
    //Метод split разделяет строку на подстроки
    //StringBuilder - При работе со строками, которые часто будут модифицироваться, в однопоточной среде.
    // append() – обновляет значение объекта, который вызвал метод
    public static String reverse(String src, String dest) {
        //Этот метод позволяет сделать реверс по указанной подстроке в строке
        if (dest.length() > src.length()) {
            return "Wrong data! Try next time!";
        }
        StringBuilder reverseString = new StringBuilder();
        int startIndex = src.indexOf(dest);
        if (startIndex == -1) {
            return "SubString is not found!";
        }
        reverseString.append(src.substring(0,startIndex));
        for (int i = dest.length() - 1; i >= 0; i--) {
            reverseString.append(dest.charAt(i));
        }
        reverseString.append(src.substring(startIndex + dest.length()));
        return reverseString.toString();
    }
    //indexOf - возвращает индекс, под которым символ или строка первый раз появляется в строке;
    //возвращает (-1) если символ или строка не найдены
    public static String reverse(String src, int firstIndex, int lastIndex) {
        //Этот метод позволяет указать с какого индекса нужно сделать реверс
        if (lastIndex > src.length() || firstIndex < 0 ||  firstIndex >= lastIndex) {
            return "Wrong data! Try next time!";
        }
        StringBuilder reverseString = new StringBuilder();
        reverseString.append(src.substring(0,firstIndex));
        for (int i = lastIndex - 1; i >= firstIndex; i--) {
            reverseString.append(src.charAt(i));
        }
        reverseString.append(src.substring(lastIndex));
        return reverseString.toString();
    }
    //charAt - возвращает символ, стоящий на определенном индексе.
}

