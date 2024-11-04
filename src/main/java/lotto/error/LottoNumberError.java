package lotto.error;

import lotto.error.format.ErrorMessageFormat;

public enum LottoNumberError {

    INVALID_NUMBERS_COUNT("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("로또 번호는 중복될 수 없습니다.");

    private final String message;
    private final String prefix = ErrorMessageFormat.PREFIX.getMessage();

    LottoNumberError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return prefix + message;
    }
}
