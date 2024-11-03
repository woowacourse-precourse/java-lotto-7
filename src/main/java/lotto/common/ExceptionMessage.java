package lotto.common;

public enum ExceptionMessage {
    INPUT_NOT_NUMBER("숫자로 변환될 수 없는 입력입니다."),
    NUMBER_INVALID_RANGE("번호는 1과 45사이의 숫자여야 합니다."),
    MONEY_INVALID_RANGE("구입 금액은 0 이상이어야 합니다."),
    MONEY_CANNOT_DIVIDE_BY_LOTTO_PRICE("금액이 1000의 배수여야 합니다."),
    NUMBER_DUPLICATED("번호가 중복됩니다."),
    INVALID_COUNT_NUMBERS("당첨 번호는 6개여야 합니다."),
    INVALID_FORMAT("부적절한 형식의 입력입니다."),
    INVALID_INPUT("부적절한 입력입니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
