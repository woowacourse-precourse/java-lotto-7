package lotto.exception.lotto;

import lotto.exception.ErrorCode;

public enum LottoErrorCode implements ErrorCode {
    INVALID_LOTTO_LENGTH("로또 번호는 6개여야 합니다."),
    INVALID_DUPLICATE_LOTTO_NUMBERS("로또 번호에 중복된 숫자가 있으면 안됩니다.");

    private final String message;

    LottoErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
