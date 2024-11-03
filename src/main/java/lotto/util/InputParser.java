package lotto.util;

import lotto.message.InputErrorMessage;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class InputParser {

    public int parseBuy(String inputBuy) {
        ValidationUtils.validateBuyAmount(inputBuy);
        return Integer.parseInt(inputBuy);
    }

    public Set<Integer> parseWinningNumbers(String winningNumInput) {
        Set<Integer> numbers = Arrays.stream(winningNumInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));
        ValidationUtils.validateWinningNumbers(numbers);
        return numbers;
    }

    public int parseBonusNumber(String bonusNumInput) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonusNumInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorMessage.NON_NUMERIC_PURCHASE_AMOUNT.getMessage());
        }
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_WINNING_NUMBER_RANGE.getMessage());
        }
        return bonusNumber;
    }
}