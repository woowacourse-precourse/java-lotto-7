package lotto.global.exception;

import lotto.global.enums.ExceptionMessage;

public class DuplicatedLottoNumberException extends IllegalArgumentException {
    public DuplicatedLottoNumberException() {
        super(ExceptionMessage.DUPLICATED_LOTTO_NUMBER.getMessage());
    }
}
