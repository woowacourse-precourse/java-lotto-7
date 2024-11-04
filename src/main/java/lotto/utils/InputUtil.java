package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class InputUtil {
    private static final String SPLIT_DELIMITER = ",";

    public static int toIntStringNumberParser(String number) {
        return Integer.parseInt(number);
    }

    public static List<Integer> lottoNumberParser(String input) {
        String[] parts = input.split(SPLIT_DELIMITER);
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            numbers.add(Integer.parseInt(part.trim()));
        }
        return numbers;
    }
}