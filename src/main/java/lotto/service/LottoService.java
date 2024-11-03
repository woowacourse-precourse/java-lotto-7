package lotto.service;

import lotto.domain.Money;

public class LottoService {
    private Money money;

    public void checkAndConvertInputMoney(String moneyInput) {
        if (moneyInput.isEmpty()) {
            // 예외 처리
        }

        try {
            money = new Money(Integer.parseInt(moneyInput.trim()));
        } catch (NumberFormatException e) {
            // 예외 처리
        }
    }
}
