package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static int parse(String str) {
        return Integer.parseInt(str);
    }

    public static List<Integer> toNumbers(String str) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : str.split(",")) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
