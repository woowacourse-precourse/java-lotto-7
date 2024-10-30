package lotto.error;

public enum LottoError {

    LOTTO_PURCHASE_PRICE_NOT_DIGIT("로또 구입 가격에 숫자가 아닌 값이 포함되어 있습니다."),
    LOTTO_PURCHASE_PRICE_NOT_DIVISIBLE("로또 구입 가격이 로또 가격으로 나누어지지 않습니다."),
    LOTTO_PURCHASE_PRICE_LESS_THAN_MIN("로또 구입 가격이 최소값 미만입니다."),
    LOTTO_PURCHASE_PRICE_MORE_THAN_MAX("로또 구입 가격이 최대값 이상입니다."),

    INVALID_NUMBER("유효하지 않은 수의 형식입니다.");


    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";
    private String message;


    LottoError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format(ERROR_MESSAGE_FORMAT, message);
    }
}
