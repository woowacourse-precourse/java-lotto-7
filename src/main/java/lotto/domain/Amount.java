package lotto.domain;

public class Amount {

    public static final int LOTTO_PRICE = 1000;
    public static final String AMOUNT_ERROR_MSG = "[ERROR] 구입 금액은 1000(원) 단위의 숫자입니다. 예: 14000";

    private final int value;

    public Amount(int value) {
        validate(value);
        this.value = value;
    }

    public static Amount parse(String input) {
        try {
            return new Amount(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MSG);
        }
    }

    private void validate(int value) {

        if (value <= 0 || value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_ERROR_MSG);
        }
    }

    public int getValue() {
        return value;
    }
}
