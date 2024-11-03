package lotto.Exception.LottoNumber;

import lotto.Exception.ExceptionCode;

public enum LottoNumberInputErrorCode implements ExceptionCode {
    INCORRECT_NUMBER_COUNT("로또 번호는 %d개여야 합니다."),
    INCORRECT_DELIMITER("로또 번호는 %s로 구분 해야 합니다."),
    NUMBER_MUST_NOT_DUPLICATE("%s는 중복되어선 안됩니다.");

    private final String message;

    LottoNumberInputErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
