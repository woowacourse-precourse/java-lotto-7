package lotto.domain.util;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.NumberValidator;
import lotto.validator.Validator;

public class CreateWinningNumber {

    private final static String DELIMITER = ",";

    private CreateWinningNumber() {}

    public static List<Integer> create(String input) {
        validate(input);

        List<Integer> winningNumbers = new ArrayList<>();
        String[] inputNumbers = input.split(DELIMITER);
        for (String inputNumber : inputNumbers) {
            int winningNumber = Integer.parseInt(inputNumber.trim());
            winningNumbers.add(winningNumber);
        }
        return winningNumbers;
    }

    private static void validate(String input) {
        Validator validator = new NumberValidator();
        validator.validate(input);
    }

}
