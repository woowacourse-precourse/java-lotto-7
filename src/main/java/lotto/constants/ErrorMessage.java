package lotto.constants;

public enum ErrorMessage {

    EMPTY_INPUT_ERROR("값을 입력해주세요."),
    NUMBER_FORMAT_ERROR("양의 정수를 입력해주세요."),
    INVALID_UNIT_ERROR("금액은 1000원 단위로 입력해주세요."),
    NUMBER_SIZE_ERROR("6개의 숫자를 입력해주세요."),
    OUT_OF_RANGE_ERROR("1에서 45 사이의 숫자로 입력해주세요."),
    DUPLICATE_NUMBER_ERROR("중복되지 않는 숫자로 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
