package lotto.common;

import static lotto.common.AppConstant.LOTTO_END_RANGE;
import static lotto.common.AppConstant.LOTTO_NUMBER_COUNT;
import static lotto.common.AppConstant.LOTTO_START_RANGE;
import static lotto.common.AppConstant.LOTTO_UNIT_PRICE;

public enum AppErrorType {
    BONUS_NUMBER_DUPLICATE_ERROR("당첨 번호와 중복되지 않는 번호를 입력해주세요."),
    PARSE_NUMBER_ERROR("정수를 입력해주세요."),
    NEGATIVE_NUMBER_ERROR("양수 값을 입력해주세요."),
    DIVIDED_BY_PRICE_ERROR(LOTTO_UNIT_PRICE + "원 단위의 값을 입력해주세요."),
    NUMBER_SIZE_ERROR("로또 번호는 "+ LOTTO_NUMBER_COUNT + "개여야 합니다."),
    NUMBER_RANGE_ERROR(LOTTO_START_RANGE + "에서 " + LOTTO_END_RANGE + "사이의 값을 입력해주세요."),
    NUMBER_DUPLICATE_ERROR("중복되지 않은 값을 입력해주세요");

    private final String message;

    AppErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        String errorPrefix = "[ERROR] ";

        return errorPrefix + message;
    }
}
