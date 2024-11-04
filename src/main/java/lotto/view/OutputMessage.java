package lotto.view;

public enum OutputMessage {
    PAYMENT("구입금액을 입력해 주세요."),
    PURCHASED_LOTTO_COUNT("%d개를 구매했습니다."),
    WINNING_LOTTO("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT_PREFIX("당첨 통계"),
    DOTTED_LINE("---"),
    BONUS(", 보너스 볼 일치"),
    RANK("%d개 일치%s (%s원) - "),
    RANK_COUNT("%d개"),
    RATIO("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }
}