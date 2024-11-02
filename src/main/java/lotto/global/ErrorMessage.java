package lotto.global;

public enum ErrorMessage {
    // 도메인
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    DUPLICATED_NUMBERS_IN_LOTTO("로또 번호에 중복된 숫자가 있습니다."),
    INVALID_MONEY("구입 금액은 1,000 원 단위여야 합니다"),

    // 입출력
    NO_LINES_FOUND("입력이 없습니다"),
    INVALID_NUMBER_FORMAT("금액 형식이 올바르지 않습니다."),
    INVALID_NUMBERS("당첨 번호 형식이 올바르지 않습니다."),
    INVALID_SIZE_OF_NUMBERS("당첨 번호는 6개여야 합니다."),
    INVALID_NUMBER_RANGE("로또 번호는 1~45 사이의 숫자여야 합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    ;

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = ERROR_PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
