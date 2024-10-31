package lotto.enums;

public enum PrintMessage {
    INPUT_PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS_PROMPT("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요.");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
