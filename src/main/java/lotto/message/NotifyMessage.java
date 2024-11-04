package lotto.message;

public enum NotifyMessage {
    ENTER_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    NOTIFY_AMOUNT_MESSAGE("%d개를 구매했습니다.\n"),
    ENTER_WINNING_NUM_MESSAGE("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUM_MESSAGE("보너스 번호를 입력해 주세요."),
    NOTIFY_RESULT_MESSAGE("당첨 통계"),
    DIVIDER("---");

    private final String message;

    NotifyMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
