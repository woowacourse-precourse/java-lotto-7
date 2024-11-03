package lotto.util;

import lotto.domain.Lotto;
import lotto.enums.lotto.LottoMessage;

public class LottoValidator {

    private static final int PRICE_UNIT = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public static void validatePriceUnit(int price) {
        if (price % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_PRICE_UNIT.getMessage());
        }

        if (price <= 0) {
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_PRICE_UNIT.getMessage());
        }
    }

    public static int validNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_NUMBER_VALID.getMessage());
        }
    }

    public static void validateLottoNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_NUMBER_RANGE.getMessage());
        }
    }

    public static void validateDuplicateNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoMessage.EXCEPTION_DUPLICATE_NUMBER.getMessage());
        }
    }
}
