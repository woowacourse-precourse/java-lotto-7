package lotto.enums;

public enum InputMessage {
    // 입력 메시지
    INPUT_PURCHASE_AMOUNT("구입 금액을 입력해 주세요."),
    INPUT_LOTTO_COUNT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String inputMessage;

    InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage(Object... args) {
        return String.format(inputMessage, args);
    }
}
