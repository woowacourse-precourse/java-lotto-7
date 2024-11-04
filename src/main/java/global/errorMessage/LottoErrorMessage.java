package global.errorMessage;

public enum LottoErrorMessage {
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("중복 되지 않은 로또 번호를 입력하세요.")

    ;

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
