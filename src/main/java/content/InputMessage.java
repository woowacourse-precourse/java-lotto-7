package content;

public enum InputMessage {
    INPUT_BUY_AMOUNT("구매금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    public String getMessage() {
        return message;
    }

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }
}
