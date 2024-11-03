package lotto.common;

public enum ErrorMessage {
    NEGATIVE_INPUT_ERROR("양수인 숫자를 입력해주세요."),
    INVALID_MONEY_FORMAT("로또 금액은 1000원 단위로 투입되어야 합니다."),
    CAN_NOT_CONVERT_TO_INT("숫자를 입력해주세요."),

    INVALID_INPUT_FORMAT("입력에 숫자와 쉼표만 포함되어야 합니다."),
    OUT_OF_RANGE("입력된 번호는 1과 45 사이의 숫자여야 합니다."),
    LOTTO_CONFLICT_ERROR("중복된 로또 번호가 존재합니다."),
    INVALID_LOTTO_COUNT("로또 번호는 6개여야 합니다."),
    EMPTY_INPUT("아무것도 입력되지 않았습니다. 로또 번호를 입력해주세요.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
