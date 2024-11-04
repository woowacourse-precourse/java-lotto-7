package lotto.exception;

public class ErrorMessages {
    public static final String EMPTY_INPUT = "[ERROR] 입력값이 비어 있습니다. 다시 입력해 주세요.";
    public static final String LONG_INPUT = "[ERROR] 입력값이 너무 깁니다.";
    public static final String INVALID_AMOUNT_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    public static final String INVALID_NUMBER_FORMAT = "[ERROR] 유효하지 않은 입력입니다. 숫자를 입력해 주세요.";
    public static final String INVALID_WINNING_NUMBER_COUNT = "[ERROR] 당첨 번호는 6개의 숫자여야 합니다.";
    public static final String WINNING_NUMBER_OUT_OF_RANGE = "[ERROR] 각 당첨 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_WINNING_NUMBER = "[ERROR] 당첨 번호는 중복되지 않은 숫자여야 합니다.";
    public static final String BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 숫자여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1과 45 사이여야 합니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
}
