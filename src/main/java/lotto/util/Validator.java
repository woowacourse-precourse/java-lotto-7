package lotto.util;

import lotto.message.ErrorMessage;

import java.math.BigInteger;

public class Validator {
    public BigInteger validPurchaseMoney(String number) {
        if (!isNumber(number))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.NONE_NUMBER);

        return new BigInteger(number);
    }

    public boolean isNumber(String number) {
        return number.matches("\\d+");
    }
}
