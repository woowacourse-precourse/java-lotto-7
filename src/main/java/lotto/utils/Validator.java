package lotto.utils;

public class Validator {
    private static final int DIVIDED_AMOUNT = 1000;
    public static final String INVALID_NUMBER_MESSAGE = "[ERROR] 숫자 입력하셔야 합니다.";
    public static final String INVALID_AMOUNT_MESSAGE = "[ERROR] 1000원 단위로 입력하셔야 합니다.";

    private Validator() {
    }

    public static void isNumber(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    public static void amountIsMultipleOf1000(int amount) {
        if (amount % DIVIDED_AMOUNT != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_MESSAGE);
        }
    }
}
