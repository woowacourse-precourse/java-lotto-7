package lotto.constants;

public enum InputMessage {
    INPUT_BUDGET_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_MESSAGE("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_MESSAGE("\n보너스 번호를 입력해 주세요."),
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
