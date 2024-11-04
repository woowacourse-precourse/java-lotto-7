package lotto.Exception;

import static lotto.utils.LottoRules.*;

public enum LottoExceptionType implements ExceptionType {
    LOTTO_NUMBER_EMPTY_ERROR("로또 번호는 빈 값을 받을 수 없습니다."),
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 번호는 중복이 없어야 합니다."),
    LOTTO_NUMBER_RANGE_ERROR(
            "로또 번호는 " + LOTTO_MIN_NUMBER + "부터 " + LOTTO_MAX_NUMBER + " 사이의 숫자여야 합니다."
    ),
    LOTTO_NUMBER_NAN_ERROR("로또 번호는 숫자여야 합니다.");

    private final String message;

    LottoExceptionType(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return PREFIX_ERROR_MESSAGE + message;
    }
}
