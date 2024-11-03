package lotto.message;

public enum OutputMessage {
    PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요."),
    PURCHASED_TICKET_COUNT("%d개를 구매했습니다.\n"),
    WINNING_NUMBER_PROMPT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_HEADER("\n당첨 통계\n---"),
    MATCH_COUNT_MESSAGE("%d개 일치 (%s원) - %d개\n"),
    MATCH_COUNT_MESSAGE_WITH_BONUS("5개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    TOTAL_RETURN_MESSAGE("총 수익률은 %s%%입니다."),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
