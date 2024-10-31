package lotto.view.input;

public enum InputError {
    IS_NOT_NUMBER("숫자 형식이 아닙니다."),
    PURCHASE_AMOUNT_UNIT_ERR("구입 금액은 1,000원 단위여야 합니다."),
    MAX_AMOUNT_ERR("최대 구매 가능 금액은 100,000원 입니다."),
    MIN_AMOUNT_ERR("최소구매 가능 금액은 1,000원 입니다."),
    WINNING_NUMBERS_SIZE_ERR("당첨번호는 6개여야 합니다."),
    LOTTO_NUM_OUT_OF_RANGE_ERR("로또 번호의 숫자 범위는 1~45까지 입니다.")
    ;

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
