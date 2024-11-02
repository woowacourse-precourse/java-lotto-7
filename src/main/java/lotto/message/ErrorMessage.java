package lotto.message;

public enum ErrorMessage {
    BLANK_MESSAGE("[ERROR] 빈 문자열을 입력하였습니다."),
    INVALID_NUMBER("[ERROR] 유효한 숫자가 아닙니다."),
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    LOTTO_NUMBER_NOT_IN_RANGE("[ERROR] 로또 번호가 1 ~ 45사이의 숫자가 아닙니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호가 중복된 숫자입니다."),
    BONUS_NUMBER_DUPLICATE("[ERROR] 보너스 번호가 중복된 숫자입니다.");

    private final String errorMessage;

    ErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public final String getErrorMessage() {
        return errorMessage;
    }

}
