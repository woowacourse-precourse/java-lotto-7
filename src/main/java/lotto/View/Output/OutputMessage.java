package lotto.View.Output;

import java.util.List;

public enum OutputMessage {
    PAYMENT("구입금액을 입력해 주세요."),
    PURCHASED_TICKETS_COUNT("%d개를 구매했습니다."),
    EXPECTED_LOTTO_NUM("당첨 번호를 입력해 주세요."),
    EXPECTED_BONUS_NUM("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계"),
    DOTTED_LINE("---"),
    BONUS(", 보너스 볼 일치"),
    NONE(""),
    RANK_COUNT("%d개 일치%s (%s원) - %d개"),
    RATE_OR_RETURN("총 수익률은 %.1f%%입니다."),
    LOTTO_NUM("[%s, %s, %s, %s, %s, %s]");

    private final String message;

    OutputMessage(String message) {
        this.message=message;
    }

    String getMessage() {
        return message;
    }

    String getArgsMessage(Object... args) {
        return String.format(message, args);
    }

    String getArgsMessage(List<Integer> args) {
        return String.format(message, args.toArray());
    }
}
