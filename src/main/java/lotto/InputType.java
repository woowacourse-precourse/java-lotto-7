package lotto;

public enum InputType {
    PURCHASE("구입금액을 입력해 주세요."),
    WIN_LOTTO("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요.");

    private final String Message;

    InputType(String Message) {
        this.Message = Message;
    }

    public String getMessage() {
        return Message;
    }
}
