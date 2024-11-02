package lotto.handler;

import static lotto.message.ErrorMessage.*;

public class MoneyInputHandler {
    public long getLottoCount(String inputNum) {
        while (true) {
            try {
                long rawMoney = convertToLong(inputNum);
                return validateMoney(rawMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public long convertToLong(String inputNum) {
        try {
            return Long.parseLong(inputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_PURCHASE_AMOUNT.getMessage());
        }
    }

    long validateMoney(long rawMoney) {
        if (rawMoney < 0) {
            throw new IllegalArgumentException(NEGATIVE_PURCHASE_AMOUNT.getMessage());
        }
        if (rawMoney % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
        }
        return rawMoney / 1000;
    }
}
