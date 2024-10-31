package lotto.validation;

public class LotteryValidator {

    // 숫자로 변환된 구매 금액
    public void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

}
