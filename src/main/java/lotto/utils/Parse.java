package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class Parse {
    public static List<Integer> winningNumbers(String buffer) {
        String[] numbers = splitNumbers(buffer);
        return convertToIntegerList(numbers);
    }

    public static String[] splitNumbers(String buffer) {
        String[] numbers = buffer.split(",");
        return numbers;
    }

    public static List<Integer> convertToIntegerList(String[] numbers) {
        List<Integer> numberList = new ArrayList<>();
        for (String number : numbers) {
            numberList.add(Integer.parseInt(number));
        }
        return numberList;
    }
}
