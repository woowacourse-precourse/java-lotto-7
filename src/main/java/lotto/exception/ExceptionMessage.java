package lotto.exception;

public enum ExceptionMessage {
    NEGATIVE_INPUT("[ERROR] 음수 입력은 허용되지 않습니다."),
    THOUSAND_UNIT_ONLY("[ERROR] 천 단위 입력만 허용됩니다."),
    INVALID_NUMBER("[ERROR] 입력이 숫자형식이 아니거나 입력 가능값을 초과했습니다."),
    NO_SUCH_ELEMENT("[ERROR] 입력값이 없습니다."),
    INVALID_LOTTO_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 6개의 로또 번호는 중복되면 안됩니다.");


    ExceptionMessage(String message) {
        this.message = message;
    }

    private final String message;

    public String getMessage() {
        return message;
    }
}
