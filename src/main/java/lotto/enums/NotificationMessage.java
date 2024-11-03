package lotto.enums;

public enum NotificationMessage {
    PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASED_LOTTOS("%d개를 구매했습니다."),
    PROFIT_RATE("총 수익률은 %.1f%%입니다."),
    MATCH_COUNT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),  // 보너스 일치 포함 포맷
    MATCH_COUNT_NO_BONUS("%d개 일치 (%s원) - %d개"),  // 보너스 일치 미포함 포맷
    DIVIDER("");

    private final String message;

    NotificationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
