package lotto.constant.message;

public enum InputMessage {

    LOTTO_PURCHASE_AMOUNT_INPUT_MESSAGE("구입 금액을 입력해 주세요."),
    WINNING_TICKET_INPUT_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("\n보너스 번호를 입력해 주세요.")
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
