package lotto.validation;

public class Validation {
    public void purchase(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }
}
