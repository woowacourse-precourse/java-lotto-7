package lotto.util.message;

public final class ErrorMessage {
    private static final String PREFIX = "[ERROR] ";
    public static final String NUMBER_FORMAT_ERROR = PREFIX + "올바른 숫자를 입력해 주세요.";
    public static final String NEGATIVE_AMOUNT_ERROR = PREFIX + "구입금액은 0 이상의 값이어야 합니다.";
    public static final String AMOUNT_UNIT_ERROR = PREFIX + "구입금액은 1,000원으로 나누어 떨어져야 합니다.";

    private ErrorMessage() {
    }
}
