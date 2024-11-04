package lotto.handler;

import static lotto.constant.LottoValues.*;
import static lotto.message.ErrorMessage.*;
import static lotto.view.RequestView.getMoney;

public class MoneyInputHandler {
    public long getLottoCount() {
        while (true) {
            try {
                String inputNum = getMoney();
                int rawMoney = convertToInt(inputNum);
                return validateMoney(rawMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int convertToInt(String inputNum) {
        try {
            return Integer.parseInt(inputNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_INTEGER_PURCHASE_AMOUNT.getMessage());
        }
    }

    long validateMoney(long rawMoney) {
        validateMoneyScope(rawMoney);
        validateMoneyUnit(rawMoney);
        return rawMoney / LOTTO_PRICE.value();
    }

    private void validateMoneyScope(long rawMoney) {
        if (rawMoney < LOTTO_MONEY_MIN_LIMIT.value()) {
            throw new IllegalArgumentException(NEGATIVE_PURCHASE_AMOUNT.formatValue(LOTTO_MONEY_MIN_LIMIT.value()));
        }
        if (rawMoney > LOTTO_MONEY_MAX_LIMIT.value()){
            throw new IllegalArgumentException(OVERFLOW_PURCHASE_AMOUNT.formatValue(LOTTO_MONEY_MAX_LIMIT.value()));
        }
    }

    private void validateMoneyUnit(long rawMoney) {
        if (rawMoney % LOTTO_PRICE.value() != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_UNIT.formatValue(LOTTO_PRICE.value()));
        }
    }
}
