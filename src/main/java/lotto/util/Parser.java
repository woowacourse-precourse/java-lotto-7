package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.common.Constants;
import lotto.common.ErrorMessages;

public class Parser {
    private final Validator validator;

    public Parser(Validator validator) {
        this.validator = validator;
    }

    public int parsePayment(String input) {
        input = removeEmptySpaces(input);
        try {
            int payment = Integer.parseInt(input);
            validator.validatePayment(payment);
            return payment;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMERIC_FORMAT);
        }
    }

    public List<Integer> parseWinningNumbers(String input) {
        String[] splitNumbers = split(input);
        try {
            List<Integer> winningNumbers = Arrays.stream(splitNumbers)
                    .map(Integer::parseInt)
                    .toList();
            validator.validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMERIC_FORMAT);
        }
    }

    public int parseBonus(String input) {
        input = removeEmptySpaces(input);
        try {
            int bonus = Integer.parseInt(input);
            validator.validateLottoNumber(bonus);
            return bonus;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMERIC_FORMAT);
        }
    }

    private String[] split(String input) {
        return removeEmptySpaces(input).split(Constants.DELIMITER);
    }

    private String removeEmptySpaces(String input) {
        return input.replaceAll(Constants.SPACE, Constants.EMPTY_STRING);
    }
}
