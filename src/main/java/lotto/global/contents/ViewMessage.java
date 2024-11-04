package lotto.global.contents;

import java.util.List;

public enum ViewMessage {

    NEW_LINE("\n"),
    LOTTO_NUMBER_SEPARATOR(", "),
    QUESTION_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    QUESTION_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    QUESTION_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨통계\n---"),
    WINNING_RESULT_FORMAT("%d개 일치 (%,d원) - %d개"),
    WINNING_SECOND_FORMAT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    WINNING_RATE_SUM_FORMAT("총 수익률은 %.1f%%입니다."),
    PURCHASE_LOTTO_COUNT("%d개를 구매했습니다."),
    LOTTO_OUTPUT_FORMAT("[%s]");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String formatMessage(Object... args) {
        return String.format(message, args);
    }

    public String joinMessage(List<String> args) {
        return String.join(message, args);
    }

    @Override
    public String toString() {
        return message;
    }
}
