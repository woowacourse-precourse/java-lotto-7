package lotto.view;

import static lotto.resources.Constants.COMMA;
import static lotto.resources.Constants.CONTINUOUS_COMMA_REGEX;
import static lotto.resources.Constants.NUMBER_AND_COMMA_REGEX;
import static lotto.resources.Constants.ONLY_NUMBER_REGEX;
import static lotto.resources.ErrorMessages.INVALID_CONSECUTIVE_COMMAS;
import static lotto.resources.ErrorMessages.INVALID_EMPTY_OR_WHITESPACE;
import static lotto.resources.ErrorMessages.INVALID_END_WITH_COMMA;
import static lotto.resources.ErrorMessages.INVALID_NULL_INPUT;
import static lotto.resources.ErrorMessages.INVALID_NUMERIC_INPUT;
import static lotto.resources.ErrorMessages.INVALID_NUMERIC_OR_COMMA_INPUT;
import static lotto.resources.ErrorMessages.INVALID_START_WITH_COMMA;
import static lotto.resources.Messages.INPUT_BONUS_NUMBER;
import static lotto.resources.Messages.INPUT_MONEY;
import static lotto.resources.Messages.INPUT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputMoney() {
        return inputWithValidation(INPUT_MONEY.getMessage(), this::validateInputNumber);
    }

    public String inputWinningNumbers() {
        return inputWithValidation(INPUT_WINNING_NUMBERS.getMessage(), this::validateInputWinningNumbers);
    }

    public String inputBonusNumber() {
        return inputWithValidation(INPUT_BONUS_NUMBER.getMessage(), this::validateInputNumber);
    }

    private String inputWithValidation(String prompt, InputValidator validator) {
        while (true) {
            try {
                System.out.println(prompt);
                String input = Console.readLine();
                validator.validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateInputNumber(final String input) {
        noNull(input);
        noBlank(input);
        onlyInputNumber(input);
    }

    private void validateInputWinningNumbers(final String input) {
        noNull(input);
        noBlank(input);
        onlyInputNumberOrComma(input);
        noStartWithComma(input);
        noEndWithComma(input);
        hasNoContinuousComma(input);
    }

    private void noNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException(INVALID_NULL_INPUT.getMessage());
        }
    }

    private void noBlank(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(INVALID_EMPTY_OR_WHITESPACE.getMessage());
        }
    }

    private void onlyInputNumber(final String input) {
        if (!ONLY_NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NUMERIC_INPUT.getMessage());
        }
    }

    private void onlyInputNumberOrComma(final String input) {
        if (!NUMBER_AND_COMMA_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NUMERIC_OR_COMMA_INPUT.getMessage());
        }
    }

    private void noStartWithComma(final String input) {
        if (input.startsWith(",")) {
            throw new IllegalArgumentException(INVALID_START_WITH_COMMA.getMessage());
        }
    }

    private void noEndWithComma(final String input) {
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(INVALID_END_WITH_COMMA.getMessage());
        }
    }

    private void hasNoContinuousComma(final String input) {
        if (CONTINUOUS_COMMA_REGEX.matcher(input).find()) {
            throw new IllegalArgumentException(INVALID_CONSECUTIVE_COMMAS.getMessage());
        }
    }

    @FunctionalInterface
    private interface InputValidator {
        void validate(String input);
    }
}
