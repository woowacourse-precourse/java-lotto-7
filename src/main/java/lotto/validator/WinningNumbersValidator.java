package lotto.validator;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.view.message.ErrorMessage;

public class WinningNumbersValidator {
    private static final String COMMA = ",";

    public static List<Integer> validate(String input) {
        InputValidator.validateNotEmpty(input);
        validateContainsComma(input);

        List<Integer> winningNumbers = new ArrayList<>();

        String[] numbers = input.split(COMMA);
        for (String number : numbers) {
            InputValidator.validateIsNumeric(number);

            int winningNumber = Integer.parseInt(number);
            InputValidator.validateIsPositive(winningNumber);

            winningNumbers.add(Integer.parseInt(number));
        }

        validateLotto(winningNumbers);

        return winningNumbers;
    }

    private static void validateContainsComma(String input) {
        if (!input.contains(COMMA)) {
            throw new IllegalArgumentException(ErrorMessage.NO_COMMA.getMessage());
        }
    }

    private static void validateLotto(List<Integer> winningNumbers) {
        new Lotto(winningNumbers);
    }
}
