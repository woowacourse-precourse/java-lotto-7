package lotto.util;

import java.util.List;

public class Validator {
    private static final int NUMBERS_SIZE = 6;
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int LOTTO_PRICE = 1000;

    public static boolean validateNumbers(List<Integer> numbers, Integer bonusNumber) {
        checkNumberSize(numbers);
        checkNumberDuplicates(numbers, bonusNumber);
        for(Integer number : numbers) {
            checkNumberRange(number);
        }
        checkNumberRange(bonusNumber);

        return true;
    }

    public static boolean validateMoney(Integer money) {
        checkMoneyRange(money);
        checkMoneyIsDividedByLottoPrice(money);

        return true;
    }

    private static void checkNumberSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException("Number must be 6 numbers");
        }
    }

    private static void checkNumberDuplicates(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("Number must be distinct numbers");
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Bonus number is already in the list");
        }
    }

    private static void checkNumberRange(Integer number){
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Number must be between " + MIN_NUMBER + " and " + MAX_NUMBER);
        }
    }

    private static void checkMoneyRange(Integer money){
        if (money < 0) {
            throw new IllegalArgumentException("Money must be greater than zero");
        }
    }

    private static void checkMoneyIsDividedByLottoPrice(Integer money){
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("Money must be a multiple of " + LOTTO_PRICE);
        }
    }
}
