package lotto.error;

public enum LottoErrorMessage implements ErrorMessage {
    UNMATCHED_SIZE("로또 번호는 6개여야 합니다.");

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
