package lotto.view;

public class ErrorMessage {
    private static final int MIN_PRICE = 1_000;
    private static final int MAX_PRICE = Integer.MAX_VALUE;

    private static final String NOT_VALID_PRICE_RANGE = "[ERROR] 구입금액은 " + MIN_PRICE + "원 이상, " + MAX_PRICE + "원 이하의 숫자만 입력 가능합니다.";
    private static final String PRICE_WITH_REMAINDER = "[ERROR] 구입금액은 " + MIN_PRICE + "원으로 나누어 떨어져야 합니다.";


    private static final String NOT_VALID_NUMBER = "[ERROR] 1 ~ 45 사이의 정수만 입력 가능합니다";
    private static final String NOT_VALID_NUMBERS_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복이 없어야 합니다.";

    public static String notValidPriceRange() {
        return NOT_VALID_PRICE_RANGE;
    }

    public static String priceWithRemainder() {
        return PRICE_WITH_REMAINDER;
    }

    public static String notValidNumber() {
        return NOT_VALID_NUMBER;
    }

    public static String notValidNumbersSize() {
        return NOT_VALID_NUMBERS_SIZE;
    }

    public static String duplicateNumber() {
        return DUPLICATE_NUMBER;
    }
}
