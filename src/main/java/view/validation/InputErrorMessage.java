package view.validation;

public enum InputErrorMessage {
    MONEY_EMPTY_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_NUMS_EMPTY_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUM_EMPTY_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_NUMS_FORMAT_MESSAGE("당첨 번호는 숫자와 쉼표로만 이루어져야 합니다."),
    MONEY_FORMAT_MESSAGE("구입금액은 숫자로만 이루어져야 합니다."),
    BONUS_NUM_FORMAT_MESSAGE("보너스 번호는 숫자로만 이루어져야 합니다.");

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
