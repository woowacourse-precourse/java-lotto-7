package lotto.handler;

import static lotto.message.ErrorMessage.*;
import static lotto.view.RequestView.getMoney;

public class MoneyInputHandler {
    public long getLottoCount() {
        while (true) {
            try {
                String inputNum = getMoney();
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
