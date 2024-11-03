package lotto.service;

import lotto.domain.Money;
import lotto.exception.MoneyExceptionType;

public class LottoService {
    private Money money;

    public void checkAndConvertInputMoney(String moneyInput) throws IllegalArgumentException {
        if (moneyInput.isBlank()) {
            throw new IllegalArgumentException(MoneyExceptionType.EMPTY_INPUT_MONEY.getMessage());
        }

        try {
            money = new Money(Integer.parseInt(moneyInput.trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MoneyExceptionType.NOT_INTEGER_MONEY.getMessage());
        }
    }
}
