package lotto.exception;

import static lotto.util.LottoConstants.LOTTO_NUMBERS_COUNT;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MIN;

public class InvalidLottoNumberException extends IllegalArgumentException {
    public static final String INVALID_LOTTO_NUMBERS = "당첨 번호는 " + LOTTO_NUMBERS_COUNT + "개의 숫자여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBERS = "당첨 번호는 중복될 수 없습니다.";
    public static final String OUT_OF_RANGE_NUMBER = "로또 번호는 " + LOTTO_NUMBER_MIN + "부터 "
            + LOTTO_NUMBER_MAX + " 사이의 숫자여야 합니다.";

    public static final String OUT_OF_RANGE_BONUS_NUMBER = "보너스 번호는 " + LOTTO_NUMBER_MIN + "부터 "
            + LOTTO_NUMBER_MAX + " 사이의 숫자여야 합니다.";

    public InvalidLottoNumberException(String message) {
        super(message);
    }
}
