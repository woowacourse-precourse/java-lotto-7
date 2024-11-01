package lotto.enums;

public enum InputMessage {
    // 입력 메시지
    PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getInputMessage(Object... args) {
        return String.format(message, args);
    }
}
