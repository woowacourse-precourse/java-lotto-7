package lotto.validator;

import static lotto.constants.CommonConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.CommonConstants.MIN_LOTTO_NUMBER;
import static lotto.constants.CommonConstants.POSITIVE_NUMBER_REGEX;
import static lotto.exception.ExceptionMessage.BLANK_BONUS_NUMBER;
import static lotto.exception.ExceptionMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.exception.ExceptionMessage.NON_POSITIVE_BONUS_NUMBER;
import static lotto.exception.ExceptionMessage.OUT_OF_LOTTO_NUMBER_RANGE;

import java.util.List;
import java.util.regex.Pattern;
import org.junit.platform.commons.util.StringUtils;

public class BonusNumberValidator {

    public static void validate(List<Integer> winningNumbers, String bonusNumber) {
        validateBlank(bonusNumber);
        validatePositiveNumber(bonusNumber);
        validateRange(bonusNumber);
        validateDuplication(winningNumbers, bonusNumber);
    }

    private static void validateBlank(String bonusNumber) {
        if (StringUtils.isBlank(bonusNumber)) {
            throw new IllegalArgumentException(BLANK_BONUS_NUMBER.getMessage());
        }
    }

    private static void validatePositiveNumber(String bonusNumber) {
        if (isNonPositiveNumber(bonusNumber)) {
            throw new IllegalArgumentException(NON_POSITIVE_BONUS_NUMBER.getMessage());
        }
    }

    private static boolean isNonPositiveNumber(String bonusNumber) {
        return !Pattern.matches(POSITIVE_NUMBER_REGEX, bonusNumber);
    }

    private static void validateRange(String bonusNumber) {
        int parsedNumber = Integer.parseInt(bonusNumber);
        if (outOfRange(parsedNumber)) {
            throw new IllegalArgumentException(OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private static boolean outOfRange(int num) {
        return !(MIN_LOTTO_NUMBER <= num && num <= MAX_LOTTO_NUMBER);
    }

    private static void validateDuplication(List<Integer> winningNumbers, String bonusNumber) {
        int parsedBonusNumber = Integer.parseInt(bonusNumber);
        if (winningNumbers.contains(parsedBonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }
}
