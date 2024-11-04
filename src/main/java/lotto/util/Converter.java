package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    private static final String DELIMITER = ",";

    public static int parse(String str) {
        return Integer.parseInt(str);
    }

    public static List<Integer> toNumbers(String str) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : str.split(DELIMITER)) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
