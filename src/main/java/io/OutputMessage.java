package io;

public enum OutputMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_WINNER_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요.")
    ;

    private final String outputMessage;

    private OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
