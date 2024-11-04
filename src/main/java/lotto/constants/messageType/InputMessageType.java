package lotto.constants.messageType;

public enum InputMessageType {

    INPUT_GUIDE_MESSAGE("구입금액을 입력해 주세요.");

    private final String message;

    InputMessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
