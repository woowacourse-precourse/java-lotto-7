package lotto.global.util;

import static lotto.global.constant.Config.LOTTO_PRICE;
import static lotto.global.constant.ErrorMessage.DIVISION_BY_ZERO;
import static lotto.global.constant.ErrorMessage.DUPLICATE_NUMBER_EXIST;
import static lotto.global.constant.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.global.constant.ErrorMessage.LOTTO_PRICE_DIVISIBILITY;
import static lotto.global.constant.ErrorMessage.NUMBER_FORMAT_PROBLEM;
import static lotto.global.constant.ErrorMessage.PRICE_CAN_NOT_BE_ZERO;

import java.util.List;
import lotto.Lotto;
import lotto.UniqueNumber;

public class Validator {
    public static void validateLotto(Lotto lotto) {
        validateDuplicateNumber(lotto);
        validateLottoNumberInRange(lotto);
    }

    private static void validateLottoNumberInRange(Lotto lotto) {
        if (!lotto.isNumbersInRange()) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    private static void validateDuplicateNumber(UniqueNumber uniqueNumber) {
        if (uniqueNumber.hasDuplicateNumber()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXIST);
        }
    }

    public static void validatePrice(String price) {
        validateNumberFormat(price);
        validateDivisibilityByLottoPrice(price);
        validatePriceNotZero(price);
    }

    private static void validatePriceNotZero(String price) {
        if (Integer.parseInt(price) == 0) {
            throw new IllegalArgumentException(PRICE_CAN_NOT_BE_ZERO);
        }
    }

    private static void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_FORMAT_PROBLEM);
        }
    }

    private static void validateDivisibilityByLottoPrice(String price) {
        int priceNumber = Integer.parseInt(price);
        if (priceNumber % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE_DIVISIBILITY);
        }
    }

    public static void validateWinningNumber(List<String> winningNumbers) {
        winningNumbers.forEach(Validator::validateNumberFormat);
        validateDuplicateWinningNumber(winningNumbers);
    }

    private static void validateDuplicateWinningNumber(List<String> winningNumbers) {
        int oldSize = winningNumbers.size();
        int newSize = (int) winningNumbers.stream().distinct().count();
        if (oldSize != newSize) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXIST);
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, String input) {
        validateNumberFormat(input);
        validateDuplicateBonusNumber(winningNumbers, input);
    }

    private static void validateDuplicateBonusNumber(List<Integer> winningNumbers, String input) {
        int bonusNumber = Integer.parseInt(input);
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXIST);
        }
    }

    public static void validateRateOfReturn(int investmentMoney) {
        validateDivisionByZero(investmentMoney);
    }

    private static void validateDivisionByZero(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException(DIVISION_BY_ZERO);
        }
    }
}
