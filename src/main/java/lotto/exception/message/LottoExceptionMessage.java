package lotto.exception.message;

import static lotto.constant.LottoConstant.*;

public enum LottoExceptionMessage {
    INVALID_LOTTO_COUNT(String.format("%d개의 숫자를 입력해주세요!", LOTTO_NUMBERS_TO_DRAW)),
    INVALID_LOTTO_NUMBER(String.format("%d 과 %d 사이 숫자를 입력해주세요!",LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)),
    DUPLICATE_LOTTO_NUMBER("숫자는 중복 될 수 없습니다!"),
    DUPLICATE_BONUS_NUMBER("보너스 숫자는 로또 숫자와 중복 될 수 없습니다!");

    private final String message;

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}