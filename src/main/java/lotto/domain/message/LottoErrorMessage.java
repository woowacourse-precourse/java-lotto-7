package lotto.domain.message;

import lotto.domain.rule.LottoRules;

public enum LottoErrorMessage {

    INVALID_LOTTO_NUMBER_IN_RANGE("[ERROR] 로또 번호는 " + LottoRules.MIN_NUMBER.getValue() + "~" + LottoRules.MAX_NUMBER.getValue() + " 사이의 정수여야 합니다."),
    INVALID_LOTTO_COUNT("[ERROR] 로또 번호는 " + LottoRules.NUMBER_COUNT.getValue() + "개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호엔 중복이 있을 수 없습니다."),
    WINNING_NUMBER_FORMAT_ERROR("[ERROR] 당첨 번호는 쉼표로 구분된 중복없는 6개의 1~45사이의 숫자 형식이어야 합니다. (예시: 1,2,3,4,5,6)");
    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}