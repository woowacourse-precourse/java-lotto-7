package lotto.util;

import static lotto.message.CommonConstants.SEPARATOR;
import static lotto.message.ErrorMessage.ERROR_NON_NUMERIC_INPUT;

import java.util.ArrayList;
import java.util.List;

public class ParseUtil {

    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_INPUT);
        }
    }

    public static List<Integer> parseToList(String input) {
        List<Integer> numbers = new ArrayList<>();
        String[] splitNumbers = input.split(SEPARATOR);

        for (String number : splitNumbers) {
            numbers.add(parseSingleNumber(number));
        }

        return numbers;
    }

    private static int parseSingleNumber(String number) {
        String trimmedNumber = number.trim();
        return parseInt(trimmedNumber);
    }

}
