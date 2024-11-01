package lotto.view;

import java.math.BigInteger;

import static lotto.exception.ExceptionCode.*;

public class InputValidator {

    public static void validateMoneyInput(String moneyInput) {
        try {
            new BigInteger(moneyInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER.message());
        }
    }

}
