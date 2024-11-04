package lotto.util.validator;

import java.util.Arrays;
import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConst;

public class InputValidator {

    private final static String MONEY_REGEX = "[1-9][0-9]*000";
    private final static String WINNING_NUMBERS_REGEX = "\\d+(,\\d+){5}";
    private final static String BONUS_NUMBER_REGEX = "\\d+";

    public static void validateMoney(String money) {
        checkNull(money);
        checkMoneyForm(money);
    }

    private static void checkMoneyForm(String money) {
        if (!money.matches(MONEY_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.MONEY_FORM_ERROR);
        }
    }

    public static void validateWinningNumbers(String winningNumbers) {
        checkNull(winningNumbers);
        checkWinningNumbersForm(winningNumbers);
        checkNumberRange(winningNumbers);
    }

    private static void checkWinningNumbersForm(String winningNumbers) {
        if (!winningNumbers.matches(WINNING_NUMBERS_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_FORM_ERROR);
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        checkNull(bonusNumber);
        checkNumber(bonusNumber);
        checkNumberRange(bonusNumber);
    }

    private static void checkNumber(String bonusNumber) {
        if (!bonusNumber.matches(BONUS_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_ERROR);
        }
    }

    private static void checkNull(String money) {
        if (money == null || money.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_ERROR);
        }
    }

    private static void checkNumberRange(String winningNumbers) {
        boolean rangeResult = Arrays.stream(winningNumbers.split(LottoConst.COMMA))
            .anyMatch(num -> Integer.parseInt(num) < LottoConst.MIN_LOTTO_NUM
                || Integer.parseInt(num) > LottoConst.MAX_LOTTO_NUM);
        if (rangeResult) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE_ERROR);
        }
    }
}
