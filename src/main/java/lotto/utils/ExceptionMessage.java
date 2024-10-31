package lotto.utils;

public enum ExceptionMessage {
    INVALID_INPUT_BUDGET("예산은 1000원 단위로 입력 가능합니다."),
    INVALID_DUPLICATED_NUMBER("중복된 숫자는 추가할 수 없습니다."),
    INVALID_LOTTO_NUMBER_RANGE("입력 가능한 로또 숫자 범위는 1이상 45이하의 정수입니다.");

    private static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return this.message;
    }

}
