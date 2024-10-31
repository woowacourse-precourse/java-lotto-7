package lotto.util;

import java.util.List;

import static lotto.common.ExceptionMessage.MONEY_CANNOT_DIVIDE_BY_LOTTO_PRICE;
import static lotto.common.ExceptionMessage.MONEY_INVALID_RANGE;
import static lotto.common.ExceptionMessage.NOT_ENOUGH_NUMBERS;
import static lotto.common.ExceptionMessage.NUMBER_DUPLICATED;
import static lotto.common.ExceptionMessage.NUMBER_INVALID_RANGE;
import static lotto.common.LottoConstant.LOTTO_PRICE;
import static lotto.common.LottoConstant.MAX_NUMBER;
import static lotto.common.LottoConstant.MIN_NUMBER;
import static lotto.common.LottoConstant.NUMBERS_SIZE;

public class Validator {

    private Validator() {
    }

    public static boolean validateNumbers(List<Integer> numbers, Integer bonusNumber) {
        checkNumberSize(numbers);
        checkNumberDuplicates(numbers, bonusNumber);
        for (Integer number : numbers) {
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
            NOT_ENOUGH_NUMBERS.printException();
            throw new IllegalArgumentException();
        }
    }

    private static void checkNumberDuplicates(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            NUMBER_DUPLICATED.printException();
            throw new IllegalArgumentException();
        }
        if (numbers.contains(bonusNumber)) {
            NUMBER_DUPLICATED.printException();
            throw new IllegalArgumentException();
        }
    }

    private static void checkNumberRange(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            NUMBER_INVALID_RANGE.printException();
            throw new IllegalArgumentException();
        }
    }

    private static void checkMoneyRange(Integer money) {
        if (money < 0) {
            MONEY_INVALID_RANGE.printException();
            throw new IllegalArgumentException();
        }
    }

    private static void checkMoneyIsDividedByLottoPrice(Integer money) {
        if (money % LOTTO_PRICE != 0) {
            MONEY_CANNOT_DIVIDE_BY_LOTTO_PRICE.printException();
            throw new IllegalArgumentException();
        }
    }
}
