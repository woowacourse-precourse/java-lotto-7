package lotto.view.global;

public enum PrintMessage {

    INPUT_AMOUNT("구입금액을 입력해 주세요.");

    private String message;

    PrintMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
