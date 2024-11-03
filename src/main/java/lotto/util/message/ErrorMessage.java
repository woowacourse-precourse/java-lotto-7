package lotto.util.message;

public final class ErrorMessage {
    private static final String PREFIX = "[ERROR] ";
    public static final String EMPTY_INPUT_ERROR = PREFIX + "빈 문자열이 입력되었습니다.";
    public static final String NUMBER_FORMAT_ERROR = PREFIX + "올바른 숫자를 입력해 주세요.";
    public static final String INVALID_AMOUNT_ERROR = PREFIX + "구입금액은 양수값이어야 합니다.";
    public static final String AMOUNT_UNIT_ERROR = PREFIX + "구입금액은 1,000원으로 나누어 떨어져야 합니다.";
    public static final String CONTAIN_SPACE_ERROR = PREFIX + "공백이 함께 입력되었습니다.";
    public static final String NUMBER_RANGE_ERROR = PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String DUPLICATE_NUMBER_ERROR = PREFIX + "당첨 번호는 중복된 숫자가 없어야 합니다.";
    public static final String DUPLICATE_BONUS_ERROR = PREFIX + "보너스 번호는 당첨 번호와 중복되지 않아야 합니다.";

    private ErrorMessage() {
    }
}
