package lotto.view.global;

public enum MessageType {

    START_MESSAGE("구입금액을 입력해 주세요.`를 출력한다.");

    private String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
