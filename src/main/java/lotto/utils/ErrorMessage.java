package lotto.utils;

public class ErrorMessage {
    public static final String INVALID_LOTTO_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 중복된 번호가 존재합니다!";
    public static final String INVALID_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 1000원 단위의 양수여야 합니다.";
    public static final String NON_NUMERIC_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 숫자로 입력해 주세요.";
    public static final String INVALID_WINNING_NUMBERS_FORMAT = "[ERROR] 당첨 번호는 쉼표로 구분된 6개의 숫자로 입력해야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String NON_NUMERIC_BONUS_NUMBER = "[ERROR] 보너스 번호는 숫자로 입력해 주세요.";
    public static final String INVALID_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
}
