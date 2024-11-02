package lotto.validator;

import lotto.model.Lotto;

public class LottoBuyValidator {

    private static final String MONEY_NON_POSITIVE_ERROR_MESSAGE = "로또 가격은 양수여야 합니다.";
    private static final String MONEY_AMOUNT_NON_DIVISIBLE_LOTTO_PRICE_ERROR_MESSAGE =
            "로또 구입 금액은 로또 가격(" + Lotto.PRICE + ")으로 나누어 떨어져야 합니다.";

    public void validateMoneyAmount(int moneyAmount) {
        validateMoneyPositive(moneyAmount);
        validateMoneyAmountDivisibleLottoPrice(moneyAmount);
    }

    private void validateMoneyPositive(int moneyAmount) {
        if (moneyAmount <= 0) {
            throw new IllegalArgumentException(MONEY_NON_POSITIVE_ERROR_MESSAGE);
        }
    }

    private void validateMoneyAmountDivisibleLottoPrice(int moneyAmount) {
        if (moneyAmount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(MONEY_AMOUNT_NON_DIVISIBLE_LOTTO_PRICE_ERROR_MESSAGE);
        }
    }
}
