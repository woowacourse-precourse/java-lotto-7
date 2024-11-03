package lotto.common;

public enum PrintMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASED_TICKETS_MESSAGE("%d개를 구매했습니다.\n"),
    TICKET_NUMBERS_MESSAGE("%s\n"),
    RESULT_STATISTICS_HEADER("\n당첨 통계\n---\n"),
    RANK_RESULT_MESSAGE("%d개 일치 (%s원) - %d개\n"),
    PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

