package lotto.exception;

public enum LottoErrorMessage {

    INVALID_AMOUNT_ERROR("공백이 아닌 값을 입력해주세요."),
    NOT_NUMBER_AMOUNT_ERROR("숫자를 입력해주세요."),
    LESS_MIN_AMOUNT_ERROR("1,000원 이상을 입력해주세요."),
    DIV_1_000_AMOUNT_ERROR("1,000원 단위로 입력해주세요.");

    private final String error;

    LottoErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
