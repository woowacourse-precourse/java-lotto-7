package lotto.util;

public enum Constants {
    PURCHASE_PRICE_INPUT_PROMPT("구입금액을 입력해 주세요."),
    LOTTO_COUNT_PROMPT("개를 구매했습니다."),
    COMMA(", "),
    LOTTO_NUMBER_START("["),
    LOTTO_NUMBER_END("]"),
    WINNING_NUMBERS_INPUT_PROMPT("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_PROMPT("\n보너스 번호를 입력해 주세요.");

    private final String message;

    Constants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}