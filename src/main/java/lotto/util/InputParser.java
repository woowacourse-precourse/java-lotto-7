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
        return Arrays.stream(winningNumInput.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public int parseBonusNumber(String bonusNumInput) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(bonusNumInput.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputErrorMessage.NON_NUMERIC_BONUS_NUMBER.getMessage());
        }
        return bonusNumber;
    }
}