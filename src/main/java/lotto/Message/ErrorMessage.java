package lotto.Message;

public enum ErrorMessage {
    INVALID_NUMBER("숫자가 아닙니다."),
    NOT_THOUSAND_UNIT("[ERROR] 1,000원 단위로 입력해야 합니다."),
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
