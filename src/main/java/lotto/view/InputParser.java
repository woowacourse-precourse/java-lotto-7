package lotto.view;

import java.util.ArrayList;
import java.util.List;
import lotto.validation.InputValidator;

public class InputParser {
    private static final String COMMA = ",";

    public static List<Integer> parseLottoNumbers(String input) {
        String[] splitNumbers = input.split(COMMA);
        List<String> trimNumbers = new ArrayList<>();
        for (String number : splitNumbers) {
            trimNumbers.add(number.trim());
        }

        InputValidator.validateMultiNumberInput(trimNumbers);
        return trimNumbers.stream().map(Integer::parseInt).toList();
    }

    public static int parseNumber(String input) {
        String trimNumber = input.trim();
        InputValidator.isInputNumber(trimNumber);
        return Integer.parseInt(trimNumber);
    }
}
