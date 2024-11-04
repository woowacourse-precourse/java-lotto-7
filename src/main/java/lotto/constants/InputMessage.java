package lotto.constants;

public enum InputMessage {
    GET_LOTTO_AMOUNT_MESSAGE("구입 금액을 입력해 주세요."),
    GET_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    ;
    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
