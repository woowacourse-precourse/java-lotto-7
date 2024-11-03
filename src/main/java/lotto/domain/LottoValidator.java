package lotto.domain;

import static lotto.util.ErrorMessage.*;

public class LottoValidator {

    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }
}