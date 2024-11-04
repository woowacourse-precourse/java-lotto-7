package lotto.message;

public enum InputMessage {
    PURCHASE_INFORMATION_MESSAGE("로또 구입 금액을 입력해 주세요."),
    WINNING_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요:");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}