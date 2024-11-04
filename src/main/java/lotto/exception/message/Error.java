package lotto.exception.message;

public enum Error {

    CAPTION("[ERROR] "),
    NOT_FIX_SIZE(CAPTION.message + "로또 번호는 %d개여야 합니다."),
    DUPLICATED_NUMBER(CAPTION.message + "같은 숫자는 중복될 수 없습니다."),
    NOT_NUMERIC("숫자 이외엔 입력할 수 없습니다.");

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
