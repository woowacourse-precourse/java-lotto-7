package lotto.error;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.constants.LottoConstants.LOTTO_RANGE_MAX;
import static lotto.constants.LottoConstants.LOTTO_RANGE_MIN;
import static lotto.constants.LottoConstants.LOTTO_SIZE;

public enum ErrorType {
    INVALID_PURCHASE_PRICE(LOTTO_PRICE + "원 단위로 입력해주세요."),
    DUPLICATION_BONUS_NUM("당첨 번호에 없는 보너스 번호를 입력해주세요."),
    INVALID_NUMBER_FORMAT("숫자를 입력해주세요."),
    DUPLICATION_WINNING_NUM("당첨 숫자는 중복될 수 없습니다. 다시 입력해주세요."),
    INSUFFICIENT_OR_EXCESSIVE_NUMBERS("당첨 숫자는 " + LOTTO_SIZE + "개를 입력해주세요."),
    OUT_OF_RANGE_NUMBER("당첨 숫자는 " + LOTTO_RANGE_MIN + LOTTO_RANGE_MAX + " 범위로 입력해주세요");

    private final String message;

    ErrorType(final String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
