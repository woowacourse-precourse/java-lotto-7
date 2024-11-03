package lotto;


public class InputValidator {

    public void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위로 입력해야합니다.");
        }
    }
}
