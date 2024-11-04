package lotto.constants;

public class ErrorMessages {

    // 구입 금액 관련 에러 메시지
    public static final String ERROR_PURCHASE_AMOUNT_NUMERIC = "[ERROR] 구입 금액은 숫자여야 합니다.";
    public static final String ERROR_PURCHASE_AMOUNT_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    public static final String ERROR_MINIMUM_AMOUNT = "[ERROR] 구입 금액은 최소 1,000원 이상이어야 합니다.";

    // 당첨 번호 관련 에러 메시지
    public static final String ERROR_WINNING_NUMBER_COUNT = "[ERROR] 당첨 번호는 6개여야 합니다.";
    public static final String ERROR_WINNING_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    public static final String ERROR_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String ERROR_NUMBER_NUMERIC = "[ERROR] 번호는 숫자여야 합니다.";
}

