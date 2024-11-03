package lotto.validator;

import lotto.common.error.MoneyErrorMessage;
import lotto.domain.LottoMachine;

public class MoneyValidator {
    private MoneyValidator() {}

    public static void validateUnit(int amount) {
        boolean isValid = amount % LottoMachine.LOTTO_UNIT_PRICE == 0;
        if (!isValid) {
            throw new IllegalArgumentException(MoneyErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getInfoMessage());
        }
    }
    public static void validateValue(int amount) {
        boolean isValid = amount >= 0;
        if (!isValid) {
            throw new IllegalArgumentException(MoneyErrorMessage.INVALID_PURCHASE_AMOUNT_VALUE.getInfoMessage());
        }
    }
}
