package lotto.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.ErrorMessage;

public class Validator {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_UNIT.format(LOTTO_PRICE));
        }
        if (purchaseAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.MIN_PURCHASE_AMOUNT.format(LOTTO_PRICE));
        }
    }

    public List<Integer> validateAndParseWinningNumbers(String input) {
        String[] numbers = input.split(",");
        if (numbers.length != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_COUNT.format(LOTTO_NUMBERS_COUNT));
        }
        Set<Integer> numberSet = new HashSet<>();
        for (String numStr : numbers) {
            try {
                int num = Integer.parseInt(numStr.trim());
                if (num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX) {
                    throw new IllegalArgumentException(
                        ErrorMessage.NUMBER_RANGE.format(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX));
                }
                numberSet.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_FORMAT.getMessage());
            }
        }
        if (numberSet.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.getMessage());
        }
        return new ArrayList<>(numberSet);
    }

    public
}
