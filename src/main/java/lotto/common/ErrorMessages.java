package lotto.common;

public class ErrorMessages {
    public static final String INVALID_LOTTO_AMOUNT = "[ERROR] 구입 금액은 0보다 커야 합니다.";
    public static final String INVALID_LOTTO_PRICE = "[ERROR] 구입 금액은 1000원 단위여야 합니다.";
    public static final String INVALID_LOTTO_COUNT = "[ERROR] 로또 번호는 6개의 숫자여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1 이상 45 이하의 숫자여야 합니다.";
    public static final String INVALID_LOTTO_DUPLICATE_NUMBER = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    public static final String INVALID_NUMBER_FORMAT = "[ERROR] 숫자 형식이 올바르지 않습니다.";

    private ErrorMessages() {}
}

