package lotto.constants.string;

import lotto.constants.Constants;

public enum OutputMessage implements Constants<String> {
    BoughtAmount("개를 구매했습니다");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    @Override
    public String getInstance() {
        return outputMessage;
    }
}
