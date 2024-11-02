package lotto.exception;

public enum ExceptionMessage {
    PRICE_DIVIDE_EXCEPTION("가격은 1000으로 나뉘어 떨어져야 합니다."),
    PRICE_NUMBER_EXCEPTION("가격은 숫자가 입력되어야 합니다."),
    LOTTO_NUMBER_COUNT_EXCEPTION("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_EXCEPTION("로또 번호는 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_EXCEPTION("이미 존재하는 로또 번호 입니다."),
    LOTTO_NUMBER_RANGE_EXCEPTION("로또 번호는 1 이상 45 이하 이어야 합니다.");


    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
