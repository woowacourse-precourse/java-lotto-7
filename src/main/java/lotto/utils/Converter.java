package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static int stringToInt(String string){
        return Integer.parseInt(string);
    }

    public static List<Integer> parseToIntegerList(List<String> stringNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
