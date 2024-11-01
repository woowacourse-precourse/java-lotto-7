package lotto.error;

import static lotto.constants.LottoConstants.*;

public enum ErrorCode {
    NULL_OR_BLANK_INPUT("[ERROR] 입력 값은 공백이나 빈 값일 수 없습니다."),
    NOT_NUMERIC_INPUT("[ERROR] 입력 값은 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_RANGE("[ERROR] 로또 번호는 " + MIN_NUMBER + "에서 "+ MAX_NUMBER + " 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호는 " + LOTTO_COUNT + "개여야 합니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 " + MIN_NUMBER + "에서 "+ MAX_NUMBER + " 사이의 숫자여야 합니다."),
    NOT_MULTIPLE_OF_THOUSAND("[ERROR] 구입 금액은 " + LOTTO_PRICE + "원 단위로 입력해야 합니다."),
    NEGATIVE_OR_ZERO_AMOUNT("[ERROR] 구입 금액은 " + LOTTO_PRICE + "원 이상이어야 합니다.");



    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}