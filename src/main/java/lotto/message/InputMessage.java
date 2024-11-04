package lotto.message;

public enum InputMessage {
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),

    INPUT_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),

    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");


    private final String inputMessage;

    InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }
}
