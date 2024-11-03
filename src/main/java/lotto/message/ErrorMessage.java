package lotto.message;

public enum ErrorMessage {
    PREFIX("[ERROR]"),
    NONE_NUMBER("수를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
