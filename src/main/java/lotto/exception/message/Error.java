package lotto.exception.message;

public enum Error {

    CAPTION("[ERROR] "),
    NOT_FIX_SIZE(CAPTION.message + "로또 번호는 %d개여야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String formatMessageOf(int num) {
        return String.format(this.message, num);
    }

    public String getMessage() {
        return message;
    }
}
