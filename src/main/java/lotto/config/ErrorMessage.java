package lotto.config;

public enum ErrorMessage {
    INVALID_INPUT_NOT_NUMERIC("유효하지 않은 입력입니다. 숫자를 입력해주세요."),
    INVALID_INPUT_PURCHASE_AMOUNT_EMPTY("구입 금액은 null 또는 빈 문자열일 수 없습니다."),
    INVALID_INPUT_PURCHASE_AMOUNT_LACK("로또를 구입하기에 충분한 금액이 아닙니다."),
    INVALID_INPUT_PURCHASE_AMOUNT_CANNOT_DIVIDE("구입 금액은 " +
            LottoConstants.LOTTO_PRICE + "원 단위로 입력해야 합니다."),
    INVALID_INPUT_LOTTO_COUNT("로또 번호는 " + LottoConstants.LOTTO_NUMBER_COUNT + "개여야 합니다."),
    INVALID_INPUT_LOTTO_RANGE("로또 번호는 " + LottoConstants.LOTTO_START_NUMBER +
            "부터 " + LottoConstants.LOTTO_END_NUMBER + " 사이여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = "[ERROR]" + " " + message;
    }

    public String getMessage() {
        return message;
    }
}
