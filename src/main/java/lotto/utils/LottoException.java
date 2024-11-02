package lotto.utils;

import lotto.constants.ErrorMessage;

public class LottoException extends IllegalArgumentException {
    public LottoException(ErrorMessage message) {
        super(message.getMessage());
        System.out.println(message.getMessage());
    }
}
