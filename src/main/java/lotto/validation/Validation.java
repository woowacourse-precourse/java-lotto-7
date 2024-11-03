package lotto.validation;

import java.util.List;

public class Validation {
    private static final int LOTTO_PRICE = 1000;
    public void purchase(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위여야 합니다.");
        }
    }

}
