package lotto.service;

import lotto.constants.ErrorViewConstants;

import java.util.HashSet;
import java.util.Set;

import static lotto.constants.ConstraintConstants.*;

public class ValidatorService {
    public static boolean validatePurchaseAmount(int purchaseAmount) {
        return purchaseAmount % PURCHASE_UNIT == 0
                && purchaseAmount >= MIN_PURCHASE_PRICE
                && purchaseAmount <= MAX_PURCHASE_PRICE;
    }

    public static boolean validateWinningNumbersFormat(String[] winningNumbers) {
        if (winningNumbers.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorViewConstants.INVALID_WINNING_NUMBERS);
        }

        for (String winningNumber : winningNumbers) {
            try {
                Integer.parseInt(winningNumber);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorViewConstants.INVALID_INPUT_TYPE);
            }
        }
        return true;
    }

    public static boolean isValidNumber(int number) {
        return number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER;
    }

    public static boolean isUniqueNumber(int[] numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int number : numbers) {
            if (numberSet.contains(number)) {
                return false;
            }
            numberSet.add(number);
        }
        return numberSet.size() == numbers.length;
    }
}
