package lotto.exception;

import lotto.util.LottoConstants;

public class InvalidLottoNumberException extends IllegalArgumentException {
    public static final String PREFIX = "[ERROR] ";
    public static final String INVALID_LOTTO_NUMBERS =
            PREFIX + "당첨 번호는 " + LottoConstants.LOTTO_NUMBERS_COUNT + "개의 숫자여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBERS = PREFIX + "당첨 번호는 중복될 수 없습니다.";
    public static final String OUT_OF_RANGE_NUMBER = PREFIX + "로또 번호는 " + LottoConstants.LOTTO_NUMBER_MIN + "부터 "
            + LottoConstants.LOTTO_NUMBER_MAX + " 사이의 숫자여야 합니다.";

    public InvalidLottoNumberException(String message) {
        super(message);
    }
}
