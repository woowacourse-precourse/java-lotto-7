package lotto.error;

public enum ErrorMessage {
    NOTNUMBERBUYAMOUNT("구매금액이 정수가 아닙니다."),
    NOTPER1000BUYAMOUNT("구매금액이 1000원 단위가 아닙니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
