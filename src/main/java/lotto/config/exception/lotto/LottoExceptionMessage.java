package lotto.config.exception.lotto;

public enum LottoExceptionMessage {
    MORE_COUNT_LOTTO_NUMBER("로또 번호는 6개여야 합니다."),
    HAS_DUPLICATE_LOTTO_NUMBER("중복된 로또 번호가 존재합니다."),
    NOT_RANGE_LOTTO_NUMBER("로또 번호는 1에서 45사이여야 합니다.");
    private final String message;

    LottoExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
