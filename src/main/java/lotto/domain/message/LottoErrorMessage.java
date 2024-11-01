package lotto.domain.message;

import lotto.domain.rule.LottoRules;

public enum LottoErrorMessage {
    INVALID_LOTTO_NUMBER_IN_RANGE("[ERROR] 로또 번호는 " + LottoRules.MIN_NUMBER.getValue() + "~" + LottoRules.MAX_NUMBER.getValue() + " 사이의 정수여야 합니다."),
    INVALID_LOTTO_COUNT("[ERROR] 로또 번호는 " + LottoRules.NUMBER_COUNT.getValue() + "개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호엔 중복이 있을 수 없습니다.");

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