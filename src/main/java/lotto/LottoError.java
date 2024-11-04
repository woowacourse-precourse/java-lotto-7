package lotto;

public enum LottoError {
    DUPLICATE_NUMBER_IN_LOTTO("로또 번호에 중복된 숫자가 있을 수 없습니다."),
    NUMBERS_COUNT_NOT_SIX("로또 번호는 6개여야 합니다."),
    WRONG_MONEY("금액은 숫자만 입력할 수 있습니다.");

    private String errorMessage;

    LottoError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public LottoException serviceException() {
        return new LottoException(this.name(), errorMessage);
    }

}
