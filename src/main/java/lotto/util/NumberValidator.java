package lotto.util;

import lotto.exception.LottoException;
import lotto.message.ExceptionMessage;

public class ValidateNumber {

    public static Integer change(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new LottoException(ExceptionMessage.INPUT_LOTTO_TYPE_EXCEPTION);
        }
    }
}
