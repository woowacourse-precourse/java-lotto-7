package lotto.message;

public enum OutputMessage {

    ISSUED_LOTTO_MESSAGE("개를 구매했습니다."),

    WINNING_STATISTICS("당첨 통계"),

    THREE_MATCHES_MESSAGE("3개 일치 (5,000원) - "),

    FOUR_MATCHES_MESSAGE("4개 일치 (50,000원) - "),

    FIVE_MATCHES_MESSAGE("5개 일치 (1,500,000원) - "),

    FIVE_AND_BONUS_BALL_MATCHES_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),

    SIX_MATCHES_MESSAGE("6개 일치 (2,000,000,000원) - "),

    MATCHES_MESSAGE_SUFFIX("개"),

    RATE_OF_RETURN_MESSAGE_PREFIX("총 수익률은 "),

    RATE_OF_RETURN_MASSAGE_SUFFIX("%입니다.");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
