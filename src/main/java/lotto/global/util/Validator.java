package lotto.global.util;

import static lotto.global.constant.Config.LOTTO_PRICE;
import static lotto.global.constant.ErrorMessage.DUPLICATE_NUMBER_EXIST;
import static lotto.global.constant.ErrorMessage.LOTTO_PRICE_DIVISIBILITY;
import static lotto.global.constant.ErrorMessage.NUMBER_FORMAT_PROBLEM;

import lotto.Lotto;
import lotto.UniqueNumber;

public class Validator {
    public static void validateLotto(Lotto lotto) {
        validateDuplicateNumber(lotto);
    }

    private static void validateDuplicateNumber(UniqueNumber uniqueNumber) {
        if (uniqueNumber.hasDuplicateNumber()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXIST);
        }
    }

    public static void validatePrice(String price) {
        validateNumberFormat(price);
        validateDivisibilityByLottoPrice(price);
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
}
