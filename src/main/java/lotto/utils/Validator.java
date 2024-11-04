package lotto.utils;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static int validatePurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT);
        }
        return amount;
    }

    public static String validateWinningNumbers(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT);
        }
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
            }
            if (!uniqueNumbers.add(num)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
            }
        }
        return input;
    }

    public static int validateBonusNumber(String input) {
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
        }
        return bonusNumber;
    }
}
