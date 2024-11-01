package lotto.constants.string;

import lotto.constants.Constants;

public enum OutputMessage implements Constants<String> {
    BOUGHT_AMOUNT("개를 구매했습니다"),
    RESULT_START_LINE("당첨 통계/n---"),

    THREE_MATCH("3개 일치 (5,000원) - %d개"),
    FOUR_MATCH("4개 일치 (50,000원) - %d개"),
    FIVE_MATCH("5개 일치 (1,500,000원) - %d개"),
    FIVE_MATCH_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    SIX_MATCH("6개 일치 (2,000,000,000원) - %d개"),

    RATE_OF_RETURN("총 수익률은 %.1f%%입니다.");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    @Override
    public String getInstance() {
        return outputMessage;
    }
}
