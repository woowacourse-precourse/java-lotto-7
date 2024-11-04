package lotto.domain;

import static lotto.utils.Constant.LOTTO_PRICE;
import static lotto.utils.Constant.MINIMUM_PRICE;

import global.errorMessage.MoneyErrorMessage;

public record InputMoney(long amount) {
    public InputMoney {
        validateInputMoney(amount);
    }

    public long getBuyAmount() {
        return amount / LOTTO_PRICE;
    }

    private void validateInputMoney(long userInputMoney) {
        if (userInputMoney % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MoneyErrorMessage.INVALID_MONEY_FORMAT.getMessage());
        }
        if (userInputMoney < MINIMUM_PRICE) {
            throw new IllegalArgumentException(MoneyErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }
}
