package lotto.controller;

import static lotto.validator.ValidatorUtils.BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.validator.ValidatorUtils.PRICE_ERROR_MESSAGE;
import static lotto.validator.ValidatorUtils.WINNING_NUMBER_ERROR_MESSAGE;

import java.util.Arrays;
import java.util.List;

public class InputConverter {

    public int convertPrice(String inputPrice) {
        try {
            return Integer.parseInt(inputPrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
    }

    public List<Integer> convertWinningNumber(String inputWinningNumber) {
        String[] inputWinningNumbers = inputWinningNumber.split(",");
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
