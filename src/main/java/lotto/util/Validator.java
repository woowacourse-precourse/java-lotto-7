package lotto.util;

import java.util.List;

import static lotto.common.ExceptionMessage.INVALID_COUNT_NUMBERS;
import static lotto.common.ExceptionMessage.MONEY_CANNOT_DIVIDE_BY_LOTTO_PRICE;
import static lotto.common.ExceptionMessage.MONEY_INVALID_RANGE;
import static lotto.common.ExceptionMessage.NUMBER_DUPLICATED;
import static lotto.common.ExceptionMessage.NUMBER_INVALID_RANGE;
import static lotto.common.LottoConstant.LOTTO_PRICE;
import static lotto.common.LottoConstant.MAX_NUMBER;
import static lotto.common.LottoConstant.MIN_NUMBER;
import static lotto.common.LottoConstant.NUMBERS_SIZE;

public class Validator {

    private Validator() {
    }

    public static boolean validateNumbers(List<Integer> numbers) {
        checkNumberSize(numbers);
        checkNumberDuplicates(numbers);
        for (Integer number : numbers) {
            checkNumberRange(number);
        }

        return true;
    }

    public static boolean validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        checkBonusNumberDuplicates(numbers, bonusNumber);
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
            throw new IllegalArgumentException(INVALID_COUNT_NUMBERS.getMessage());
        }
    }

    private static void checkNumberDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(NUMBER_DUPLICATED.getMessage());
        }
    }

    private static void checkBonusNumberDuplicates(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NUMBER_DUPLICATED.getMessage());
        }
    }

    private static void checkNumberRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(NUMBER_INVALID_RANGE.getMessage());
        }
    }

    private static void checkMoneyRange(Integer money) {
        if (money < 0) {
            throw new IllegalArgumentException(MONEY_INVALID_RANGE.getMessage());
        }
    }

    private static void checkMoneyIsDividedByLottoPrice(Integer money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_CANNOT_DIVIDE_BY_LOTTO_PRICE.getMessage());
        }
    }
}
