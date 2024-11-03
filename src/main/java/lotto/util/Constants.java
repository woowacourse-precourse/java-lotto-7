package lotto.util;

public enum Constants {
    PURCHASE_PRICE_INPUT_PROMPT("구입금액을 입력해 주세요."),
    LOTTO_COUNT_PROMPT("개를 구매했습니다."),
    COMMA(", "),
    LOTTO_NUMBER_START("["),
    LOTTO_NUMBER_END("]");

    private final String message;

    Constants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}