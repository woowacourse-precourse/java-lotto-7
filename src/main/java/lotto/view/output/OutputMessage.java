package lotto.view.output;

public enum OutputMessage {
    PURCHASED_COUNT_MESSAGE("\n%d개를 구매했습니다.\n"),
    WINNING_STATISTICS("\n당첨 통계"),
    HYPHEN("---"),
    THREE_MATCHES("3개 일치 (5,000원) - %s개\n"),
    FOUR_MATCHES("4개 일치 (50,000원) - %s개\n"),
    FIVE_MATCHES("5개 일치 (1,500,000원) - %s개\n"),
    FIVE_MATCHES_PLUS_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n"),
    SIX_MATCHES("6개 일치 (2,000,000,000원) - %s개\n"),
    TOTAL_PROFIT("총 수익률은 %s%%입니다.");


    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
