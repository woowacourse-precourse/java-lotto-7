package lotto.enums;

import java.text.DecimalFormat;

public enum NotificationMessage {
    PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASED_LOTTOS("%d개를 구매했습니다."),
    PROFIT_RATE("총 수익률은 %s입니다."),
    MATCH_COUNT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),  // 보너스 일치 포함 포맷
    MATCH_COUNT_NO_BONUS("%d개 일치 (%s원) - %d개"),  // 보너스 일치 미포함 포맷
    DIVIDER("");

    private final String message;
    private static final DecimalFormat profitFormat = new DecimalFormat("#,##0.0");

    NotificationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String format(Object... args) {
        if (this == PROFIT_RATE && args.length > 0 && args[0] instanceof Double) {
            args[0] = profitFormat.format((Double) args[0]) + "%";
        }
        return String.format(message, args);
    }
}
