package lotto.view.input;

public enum Prompt {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_BALL("보너스 번호를 입력해 주세요.");

    private final String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
