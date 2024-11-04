package lotto.constant;

public enum ErrorMessage {
    INVALID_BUDGET("1000원으로 떨어져야합니다."),
    INVALID_LOTTO("유효하지 않은 로또입니다."),
    DUPLICATION_BONUS_NUMBER("보너스 번호는 당첨 번호와 같을 수 없습니다"),
    NOT_INPUT_BUDGET("금액을 입력해주세요."),
    NOT_INPUT_INTEGER("정수를 입력해주세요."),
    DUPLICATION_LOTTO_NUMBER("로또 번호는 중복되면 안됩니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_RANGE("로또 번호는 1~45 사이여야 합니다.");



    private static final String PREFIX = "[ERROR]";
    private final String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
