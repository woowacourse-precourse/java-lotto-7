package lotto.Domain;

import lotto.Messages.ErrorMessage;
import lotto.Utils.Validator;

public class WinningNumbers {
    private static final String DELIMITER = ",";
    private Lotto numbers;

    private WinningNumbers() {
    }

    public static WinningNumbers from(String input) {
        validateInput(input);
        return new WinningNumbers();
    }

    private static void validateInput(String input) {
        checkEmpty(input);
        checkBlank(input);
        checkCharacter(input);
    }

    private static void checkEmpty(String input) {
        if (Validator.isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_WINNING_NUMBERS.getMessage());
        }
    }

    private static void checkBlank(String input) {
        if (Validator.isBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_WINNING_NUMBERS.getMessage());
        }
    }

    private static void checkCharacter(String input) {
        String[] tokens = input.split(DELIMITER);
        for (String s : tokens) {
            try {
                Integer.parseInt(s);
            } catch (NumberFormatException e) {
                String message = String.format(ErrorMessage.CHARACTER_WINNING_NUMBERS.getMessage(), DELIMITER);
                throw new IllegalArgumentException(message);
            }
        }
    }

}
