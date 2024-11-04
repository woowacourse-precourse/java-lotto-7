package lotto;

public class ErrorConstants {
    public static final String INVALID_PURCHASE_AMOUNT_NOT_A_NUMBER = "[ERROR] 구입 금액은 숫자여야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_NOT_POSITIVE = "[ERROR] 구입 금액은 양수여야 합니다.";
    public static final String INVALID_PURCHASE_AMOUNT_NOT_IN_THOUSANDS = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    public static final String LOTTO_NUMBER_GENERATION_FAILED = "[ERROR] 로또 번호 생성에 실패하였습니다.";
    public static final String INVALID_WINNING_NUMBERS_COUNT = "[ERROR] 당첨 번호는 정확히 6개의 숫자여야 합니다.";
    public static final String INVALID_WINNING_NUMBER_RANGE = "[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.";
    public static final String INVALID_WINNING_NUMBER_DUPLICATE = "[ERROR] 당첨 번호는 중복되지 않아야 합니다.";
    public static final String INVALID_WINNING_NUMBER_FORMAT = "[ERROR] 당첨 번호는 숫자로만 구성되어야 합니다.";
}