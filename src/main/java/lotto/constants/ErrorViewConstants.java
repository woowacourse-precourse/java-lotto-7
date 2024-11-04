package lotto.constants;

public class ErrorViewConstants {
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INVALID_INPUT_TYPE = ERROR_PREFIX + "숫자 형태의 입력만 가능합니다. ";
    public static final String INVALID_INPUT_CONSTRAINT = ERROR_PREFIX + "1,000원 이상 100,000원 이하의 금액만 가능합니다. ";

    public static final String INVALID_WINNING_NUMBERS = ERROR_PREFIX + "로또 번호는 1부터 45 사이의 숫자 6개여야 합니다.";
    public static final String INVALID_BONUS_NUMBERS = ERROR_PREFIX + "보너스 번호는 1부터 45 사이의 숫자여야 합니다.";
}
