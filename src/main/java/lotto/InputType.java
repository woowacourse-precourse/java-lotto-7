package lotto;

public enum InputType {
    PURCHASE("구입금액을 입력해 주세요."),
    WIN_LOTTO("\n당첨 번호를 입력해 주세요."),
    BONUS("\n보너스 번호를 입력해 주세요.");

    private final String message;

    InputType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
