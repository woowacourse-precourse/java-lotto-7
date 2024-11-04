package lotto.common;

public class ExceptionMessage {
    public static final String INVALID_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String INVALID_NUMBERS_COUNT = "[ERROR] 당첨 번호는 6개의 숫자여야 합니다.";
    public static final String INVALID_BONUS_NUMBER = "[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBERS = "[ERROR] 로또 번호에 중복된 숫자가 있으면 안됩니다.";
    public static final String NUMBER_OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBER = "[ERROR] 중복된 숫자가 있습니다: ";
    public static final String INVALID_NUMBER_FORMAT = "[ERROR] 유효한 숫자가 아닙니다";
    public static final String OUT_OF_RANGE_NUMBER = "[ERROR] 숫자는 1부터 45 사이여야 합니다: ";
    public static final String INSUFFICIENT_NUMBERS = "[ERROR] 숫자가 모자랍니다. 더 입력해주세요.";
    private ExceptionMessage() {
    }
}
