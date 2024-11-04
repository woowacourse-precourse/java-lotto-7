package lotto.global.exception;

public enum ErrorMessage {

    INVALID_BLANK_INPUT("빈 문자열 또는 공백은 입력할 수 없습니다."),
    INVALID_INPUT_FORMAT("잘못된 입력 형식입니다."),
    INVALID_ZERO_PAYMENT("0원은 구매할 수 없습니다."),
    INVALID_PAYMENT_FORMAT("1000원 단위로 입력해주세요"),
    INVALID_MAXIMUM_PAYMENT("로또 최대 구매 금액은 100,000원 입니다."),
    INVALID_NUMBER_FORMAT("양의 정수만 입력이 가능합니다."),
    INVALID_LOTTO_NUMBERS_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_DUPLICATION_NUMBER("중복된 숫자가 존재합니다."),
    INVALID_BONUS_NUMBER("당첨 번호에 포함된 숫자는 입력할 수 없습니다."),
    INVALID_NUMBER_RANGE("올바른 범위의 값이 아닙니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
