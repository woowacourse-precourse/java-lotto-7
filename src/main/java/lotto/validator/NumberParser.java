package lotto.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberParser {
    public static final String DELIMITER = ",";

    public static List<Integer> toNumbers(String input) {
        List<String> numbers = splitByDelimiter(input);
        List<Integer> toNumbers = new ArrayList<>();

        for (String number : numbers) {
            try {
                toNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new NumberFormatException("[ERROR] 숫자를 입력해 주세요.");
            }
        }
        return toNumbers;
    }

    private static List<String> splitByDelimiter(String winningNumbers) {
        return Arrays.asList(winningNumbers.split(DELIMITER));
    }
}
