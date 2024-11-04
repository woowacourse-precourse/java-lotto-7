package lotto.common;

import static lotto.common.AppConstant.ERROR_PREFIX;
import static lotto.common.AppConstant.LOTTO_END_RANGE;
import static lotto.common.AppConstant.LOTTO_NUMBER_COUNT;
import static lotto.common.AppConstant.LOTTO_START_RANGE;
import static lotto.common.AppConstant.LOTTO_UNIT_PRICE;

public enum AppErrorType {
    BONUS_NUMBER_DUPLICATE_ERROR("당첨 번호와 중복되지 않는 번호를 입력해주세요."),
    PARSE_NUMBER_ERROR("정수를 입력해주세요. (1 ~ 2,147,483,647)"),
    NEGATIVE_NUMBER_ERROR("양수 값을 입력해주세요."),
    DIVIDED_BY_PRICE_ERROR(LOTTO_UNIT_PRICE + "원 단위의 값을 입력해 주세요."),
    NUMBER_SIZE_ERROR("로또 번호는 "+ LOTTO_NUMBER_COUNT + "개여야 합니다."),
    NUMBER_RANGE_ERROR(LOTTO_START_RANGE + "에서 " + LOTTO_END_RANGE + "사이의 값을 입력해 주세요."),
    NUMBER_DUPLICATE_ERROR("중복되지 않은 값을 입력해주세요"),

    NOT_EXIST_MATCHED_WITH_BONUS_RANK_ERROR("%d개와 보너스번호가 일치하는 등수는 존재하지 않습니다."),
    NOT_EXIST_MATCHED_WITHOUT_BONUS_RANK_ERROR("%d개가 일치하고 보너스 번호가 일치하지 않는 등수는 존재하지 않습니다.");

    private final String message;

    AppErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }

    public String getMessage(Object... args) {
        return ERROR_PREFIX + String.format(message, args);
    }
}
