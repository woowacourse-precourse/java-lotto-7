package lotto.constants;

public enum ErrorMessage {

    // 입력 관련
    INPUT_EMPTY("입력이 없거나 공백이어선 안됩니다."),
    NOT_INTEGER("입력은 Integer 범위 내의 정수여야 합니다."),
    NOT_POSITIVE("입력은 양수여야 합니다."),

    // 도메인 관련
    NOT_VALID_MONEY("구입 금액은 1,000원 단위로 입력해야 합니다."),
    NOT_VALID_SIZE("로또 번호는 6개여야 합니다."),
    NOT_IN_RANGE("숫자가 유효 범위(1-45)를 벗어났습니다."),
    DUPLICATE("로또 번호는 중복되지 않아야 합니다.");

    private static final String ERROR_TAG = "[ERROR] ";

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_TAG + message;
    }
}