package lotto.util;

import lotto.message.ErrorMessage;

import java.math.BigInteger;

public class Validator {
    public BigInteger validPurchaseMoney(String number) {
        if (!isNumber(number))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.NONE_NUMBER.getMessage());

        BigInteger purchaseMoney = new BigInteger(number);
        if (!isDivisibleByThousand(purchaseMoney))
            throw new IllegalArgumentException(ErrorMessage.PREFIX.getMessage() + ErrorMessage.NONE_DIVIDE_THOUSAND.getMessage());
        return purchaseMoney;
    }

    public boolean isNumber(String number) {
        return number.matches("\\d+");
    }

    public boolean isDivisibleByThousand(BigInteger purchaseMoney) {
        return purchaseMoney.remainder(BigInteger.valueOf(1000)).equals(BigInteger.ZERO);
    }
}
