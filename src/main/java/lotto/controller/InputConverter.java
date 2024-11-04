package lotto.controller;

import static lotto.validator.ValidatorUtils.BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.validator.ValidatorUtils.PURCHASE_AMOUNT_ERROR_MESSAGE;
import static lotto.validator.ValidatorUtils.WINNING_NUMBER_ERROR_MESSAGE;

import java.util.Arrays;
import java.util.List;

public class InputConverter {

    private static final String WINNING_NUMBERS_DELIMITER = ",";

    public int convertPurchaseAmount(String inputPurchaseAmount) {
        try {
            return Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MESSAGE);
        }
    }

    public List<Integer> convertWinningNumber(String inputWinningNumber) {
        String[] inputWinningNumbers = inputWinningNumber.split(WINNING_NUMBERS_DELIMITER);
        try {
            return Arrays.stream(inputWinningNumbers)
                    .map(Integer::valueOf)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WINNING_NUMBER_ERROR_MESSAGE);
        }
    }


    public int convertBonusNumber(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_ERROR_MESSAGE);
        }
    }
}
