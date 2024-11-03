package lotto.constants.string;

import lotto.constants.Constants;

public enum OutputMessage implements Constants<String> {

    BOUGHT_AMOUNT("%d개를 구매했습니다."),
    RESULT_START_LINE("당첨 통계\n---"),
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
