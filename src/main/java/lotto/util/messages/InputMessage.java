package lotto.util.messages;

public enum InputMessage {
    INPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
