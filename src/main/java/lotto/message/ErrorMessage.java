package lotto.message;

public enum ErrorMessage implements MessageProvider {

    UNAVAILABLE_PURCHASE_AMOUNT("구매금액은 1000원 단위로 입력이 가능합니다."),
    UNAVAILABLE_LOTTO_NUMBERS("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message =  message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
