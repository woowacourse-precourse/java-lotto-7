package lotto.io;

public class UserInput {

    public long getLottoPurchaseAmount(String lottoPurchaseAmountInput) {

        try {
            long lottoPurchaseAmount = Long.parseLong(lottoPurchaseAmountInput);

            validateLottoPurchaseAmountInput(lottoPurchaseAmount);
            return lottoPurchaseAmount;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자입니다.");
        }
    }

    private void validateLottoPurchaseAmountInput(long lottoPurchaseAmount) {
        if (lottoPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위입니다.");
        }

    }
}
