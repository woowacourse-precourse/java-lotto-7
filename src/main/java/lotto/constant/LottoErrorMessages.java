package lotto.constant;

public enum LottoErrorMessages {
    INVALID_LOTTO_SIZE("번호의 개수는 6개여야 합니다."),
    NUMBER_OUT_OF_RANGE("번호는 1~45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("중복되지 않는 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");

    private static final String ERROR_PREFIX = "[ERROR] ";
    private final String message;

    LottoErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX + message;
    }
}
