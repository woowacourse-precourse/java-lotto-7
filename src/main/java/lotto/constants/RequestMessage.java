package lotto.constants;

public enum RequestMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해주세요."),
    ENTER_WINNING_NUMBERS("당첨 번호를 입력해주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해주세요.");

    private final String message;
    RequestMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
