package io;

public enum OutputMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_WINNER_NUMBERS("\r\n당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("\r\n보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("\r\n당첨 통계\r\n---"),
    NEW_LINE("\r\n"),
    DASH_SEPERATOR(" - "),
    COUNT_UNIT("개"),
    ;

    private final String outputMessage;

    private OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
