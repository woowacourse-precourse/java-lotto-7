package lotto.message;

public enum ErrorMessage implements MessageProvider {

    UNAVAILABLE_PURCHASE_AMOUNT("[ERROR] 구매금액은 1000원 단위로 입력이 가능합니다."),
    UNAVAILABLE_LOTTO_NUMBERS("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    UNAVAILABLE_TYPE_LOTTO_NUMBERS("[ERROR] 입력한 로또 번호가 숫자 형식이 아닙니다."),
    UNAVAILABLE_LOTTO_NUMBERS_LENGTH("[ERROR] 로또 번호는 6개여야 합니다."),
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
