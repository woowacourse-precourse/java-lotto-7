package lotto.constant;

public enum ErrorMessage {
    /* 로또 생성 */
    NUMBERS_SIZE_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
    NUMBERS_RANGE_ERROR("[ERROR] 로또 범위를 벗어나는 숫자가 입력되었습니다"),
    NUMBERS_DUPLICATE_ERROR("[ERROR] 중복되는 번호가 존재합니다"),
    INCLUDE_CHARACTER_ERROR("[ERROR] 문자가 포함되어 있습니다"),

    /* 구매 입력 */
    PURCHASE_PRICE_ERROR("[ERROR] 구매 금액을 딱 맞추어주세요 로또 가격: " + NumberType.LOTTO_PRICE),
    PURCHASE_PRICE_CHARACTER_ERROR("[ERROR] 숫자만 입력해주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
