package lotto.exception;

import lotto.util.LottoConstants;

public class InvalidLottoNumberException extends IllegalArgumentException{
    public static final String PREFIX_ERROR_MESSAGE = "[ERROR] ";
    public static final String INVALID_LOTTO_NUMBER_MESSAGE = PREFIX_ERROR_MESSAGE +
            "당첨 번호는 " + LottoConstants.LOTTO_NUMBERS_COUNT + "개의 숫자여야 합니다.";

    public InvalidLottoNumberException(String message) {
        super(message);
    }
}
