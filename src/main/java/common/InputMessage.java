package common;

public enum InputMessage {
    USER_BUY_LOTTO("구입금액을 입력해 주세요."),
    SYSTEM_PICK_LOTTO("당첨 번호를 입력해 주세요."),
    SYSTEM_PICK_BONUS_LOTTO("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
