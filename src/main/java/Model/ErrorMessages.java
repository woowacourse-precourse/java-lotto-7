package Model;

public class ErrorMessages {
    public static final String INVALID_PURCHASE_AMOUNT = "[ERROR] 로또 구입 금액은 1000으로 나누어 떨어져야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호는 중복 숫자가 없어야 합니다.";
    public static final String INVALID_BONUS_NUMBER_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 로또 번호와 겹치지 않아야 합니다.";
    public static final String LOTTO_NUMBER_NOT_INTEGER = "[ERROR] 로또 번호는 숫자여야 합니다.";
    public static final String BONUS_NUMBER_NOT_INTEGER = "[ERROR] 보너스 번호는 숫자여야 합니다.";
}