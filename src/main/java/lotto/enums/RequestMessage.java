package lotto.enums;

public enum RequestMessage {
    LOTTO_AMOUNT("구입 금액을 입력해주세요."),
    WINNING_NUMBER("당첨 번호를 입력해주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해주세요.");

    private final String message;

    RequestMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
