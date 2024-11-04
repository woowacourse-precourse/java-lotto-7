package lotto.exception;

public class UserErrorMessage {

    public static final String ERROR_NOT_ALLOWED_BLANK = "[ERROR] 빈 칸이 입력되었습니다. 알맞은 값을 입력해주세요.";
    public static final String ERROR_NON_NUMERIC_VALUE = "[ERROR] 입력값은 숫자만 가능합니다.";

    public static final String ERROR_NOT_ALLOWED_VALUE = "[ERROR] 잘못된 금액이 입력되었습니다. 1000원으로 나누어 떨어지는 금액을 입력해주세요.";

    public static final String ERROR_NON_INTEGER_VALUE = "[ERROR] 로또 번호는 정수만 가능합니다.";
    public static final String ERROR_VALUE_NOT_IN_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자만 가능합니다.";

    public static final String ERROR_NOT_ALLOWED_DUPLICATE = "[ERROR] 당첨 번호는 중복 불가능합니다.";
}
