package lotto.view.constant;

public enum Message {
    START("구입금액을 입력해 주세요."),
    WINNING_START("당첨 번호를 입력해 주세요."),
    BONUS_START("보너스 번호를 입력해 주세요."),
    STATISTICS("당첨 통계\n---");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
