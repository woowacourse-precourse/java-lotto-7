package exception;

public enum LottoException {
    NOT_A_NUMBER("숫자가 아닙니다."),
    CAN_NOT_DIVIDE_BY_1000("1000으로 나누어 떨어지지 않습니다."),
    OUT_OF_LOTTO_NUMBER_RANGE("로또 번호 범위를 벗어났습니다."),
    LENGTH_IS_NOT_SIX("로또 번호가 6개가 아닙니다.");

    private final String message;

    LottoException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
