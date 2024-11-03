package lotto.model;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;

import java.math.BigInteger;

public class NumberStringConverter {

    public int convert(String rawNumber) {
        try {
            BigInteger parsedNum = new BigInteger(rawNumber);

            if (parsedNum.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0
                    || parsedNum.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
                throw LottoException.from(ErrorMessage.PURCHASE_AMOUNT_TOO_LARGE);
            }

            return parsedNum.intValue();
        } catch (NumberFormatException e) {
            throw LottoException.from(ErrorMessage.PURCHASE_AMOUNT_MUST_BE_NUMBER);
        }
    }
}
