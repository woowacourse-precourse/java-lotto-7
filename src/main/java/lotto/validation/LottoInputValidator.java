package lotto.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import lotto.view.ErrorConstants;

public class LottoInputValidator {

    private static final String WINNING_NUMBER_DELIMITER = ",";

    public static String validatePurchaseAmount(String input) {
        if (!input.matches("-?\\d+")) {
            return ErrorConstants.INVALID_PURCHASE_AMOUNT_NOT_A_NUMBER;
        }
        int amount = Integer.parseInt(input);
        if (amount <= 0) {
            return ErrorConstants.INVALID_PURCHASE_AMOUNT_NOT_POSITIVE;
        }
        if (amount % 1000 != 0) {
            return ErrorConstants.INVALID_PURCHASE_AMOUNT_NOT_IN_THOUSANDS;
        }
        return null;
    }

    public static List<Integer> validateWinningNumbers(String input) {
        String[] numberStrings = input.split(WINNING_NUMBER_DELIMITER);
        if (numberStrings.length != 6) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_NUMBERS_COUNT);
        }

        List<Integer> numbers = new ArrayList<>();
        for (String numStr : numberStrings) {
            int number = parseNumber(numStr.trim());
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_NUMBER_RANGE);
            }
            numbers.add(number);
        }

        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_NUMBER_DUPLICATE);
        }
        return numbers;
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        int bonusNumber = parseNumber(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_BONUS_NUMBER_RANGE);
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_BONUS_NUMBER_DUPLICATE);
        }
        return bonusNumber;
    }

    private static int parseNumber(String numStr) {
        try {
            return Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConstants.INVALID_WINNING_NUMBER_FORMAT);
        }
    }
}
