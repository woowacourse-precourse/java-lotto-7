package lotto.vo;

public enum ErrorMessage {
    INVALID_AMOUNT("1000단위만 입력이 가능합니다."),
    INVALID_INPUT_FORMAT("입력은 숫자와 컴마만 가능합니다."),
    INVALID_INPUT("입력값이 올바르지 않습니다."),
    LOTTO_NUMBER_VALIDATION("로또 번호 6글자를 입력해주세요. (중복은 허용되지 않습니다.)"),
    INVALID_LOTTO_NUMBER_LIMIT("45 이상을 입력할 수 없습니다."),
    INVALID_INPUT_NUMBERS("숫자만 입력이 가능합니다."),
    LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    EXIST_LOTTO_NUMBER("중복 번호는 허용하지 않습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
