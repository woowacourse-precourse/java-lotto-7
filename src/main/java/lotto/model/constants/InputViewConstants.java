package lotto.model.constants;

public enum InputViewConstants {
    PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요."),
    WINNING_NUMBERS_PROMPT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요.");

    private final String message;

    InputViewConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
