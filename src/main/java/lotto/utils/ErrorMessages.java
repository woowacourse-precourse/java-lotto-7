package lotto.utils;

public final class ErrorMessages {
    // Lotto 번호 관련 에러 메시지
    public static final String INVALID_LOTTO_NUMBER_LENGTH = "로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "로또 번호는 1이상 45이하여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "로또 번호는 중복되면 안됩니다.";
    public static final String NON_INTEGER_LOTTO_NUMBER = "로또 번호는 정수여야 합니다.";

    // 구매 금액 관련 에러 메시지
    public static final String NON_POSITIVE_PURCHASE_AMOUNT = "구매 금액은 양수여야 합니다.";
    public static final String INVALID_MULTIPLE_OF_PRICE = "금액은 로또 가격의 배수여야 합니다.";
    public static final String NON_INTEGER_PURCHASE_AMOUNT = "구매 금액은 정수여야 합니다.";

    private ErrorMessages() {
        throw new UnsupportedOperationException("Utility class");
    }
}
