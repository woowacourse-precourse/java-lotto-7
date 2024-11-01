package validator;

import model.Lotto;

public class LottoBuyValidator {

    private static final String MONEY_AMOUNT_NON_DIVISIBLE_LOTTO_PRICE_ERROR_MESSAGE =
            "로또 구입 금액은 로또 가격(" + Lotto.PRICE + ")으로 나누어 떨어져야 합니다.";

    public void validateMoneyAmount(int moneyAmount) {
        validateMoneyAmountDivisibleLottoPrice(moneyAmount);
    }

    private void validateMoneyAmountDivisibleLottoPrice(int moneyAmount) {
        if (moneyAmount % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(MONEY_AMOUNT_NON_DIVISIBLE_LOTTO_PRICE_ERROR_MESSAGE);
        }
    }
}
