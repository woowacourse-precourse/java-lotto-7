package lotto.Message;

public enum ErrorMessage {
    ERROR("[ERROR] "),
    INVALID_NUMBER("숫자가 아닙니다."),
    NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.");


    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
