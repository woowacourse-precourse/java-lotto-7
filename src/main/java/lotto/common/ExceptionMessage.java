package lotto.common;

import static lotto.common.LottoConstant.TICKET_SIZE;

public class ExceptionMessage {
    public static final String UNDER_ZERO_ERROR_MESSAGE = "0과 음수는 불가능 합니다.";
    public static final String UNITS_ERROR_MESSAGE = "구입금액은 1,000원으로 나누어 떨어지는 값이여야 합니다.";
    public static final String RANGE_ERROR_MESSAGE = "%d는 1~45 범위 밖의 수입니다.";
    public static final String NOT_INTEGER_ERROR_MESSAGE = "%s는 정수가 아닙니다.";
    public static final String DUPLICATION_ERROR_MESSAGE = "%d는 중복된 번호입니다.";
    public static final String CONVERSION_ERROR_MESSAGE = "%s는 정수가 아닙니다.";
    public static final String SIZE_ERROR_MESSAGE = "정확히 " + TICKET_SIZE + "개의 번호를 입력해야 합니다.";
    public static final String ERROR_PHRASE = "[ERROR] ";
}
