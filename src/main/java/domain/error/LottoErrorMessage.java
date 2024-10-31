package domain.error;

public enum LottoErrorMessage {
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복되지 않는 6개의 숫자여야 합니다."),
    LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다.")
    ;

    private final String errorMessage;
    private final String PREFIX = "[ERROR] ";

    private LottoErrorMessage(String errorMessage) {
        this.errorMessage = PREFIX + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
