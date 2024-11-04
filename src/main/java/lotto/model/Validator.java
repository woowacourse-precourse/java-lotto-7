package lotto.model;

public class Validator {

    public void validatePositiveAmount(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 양수여야 합니다.");
        }
    }

}
