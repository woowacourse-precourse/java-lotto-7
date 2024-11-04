package lotto.validation;

public class PurchasePriceValidation {

    public void checkRange(int input) {
        if (input < 1000) {
            throw new IllegalArgumentException("입력값이 1,000원 미만입니다.");
        }
        if (input > 100000) {
            throw new IllegalArgumentException("입력값이 10만원을 초과했습니다.");
        }
    }

    public void validateDivisibleByThousand(int purchasePrice) {
        if (purchasePrice % 1000 != 0) {
            throw new IllegalArgumentException("입력값은 1,000원 단위여야 합니다.");
        }
    }

}
