package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberParser {
    public static final String DELIMITER = ",";

    public static List<Integer> toNumbers(String input) {
        input = input.replaceAll(" ", "");

        List<String> numbers = splitByDelimiter(input);
        List<Integer> toNumbers = new ArrayList<>();

        for (String number : numbers) {
            toNumbers.add(Integer.parseInt(number));
        }
        return toNumbers;
    }

    private static List<String> splitByDelimiter(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(DELIMITER));
    }
}
