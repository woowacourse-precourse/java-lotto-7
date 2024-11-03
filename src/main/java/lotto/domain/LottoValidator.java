package lotto.domain;

import static lotto.util.ErrorMessage.*;

public class LottoValidator {

    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    public static void validateMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(INVALID_MONEY.getMessage());
        } else if (money % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_MONEY.getMessage());
        }
    }
}