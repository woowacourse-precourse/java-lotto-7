package view.message;

import java.math.BigDecimal;

public class ExceptionMessage {

    public static final String BANK_EXCEPTION_MESSAGE = "입력값이 빈 공백이거나 비어있으면 안 됩니다.";
    public static final String NUMBER_EXCEPTION_MESSAGE = "입력값은 숫자여야 합니다.";
    public static final String NUMBER_REGEX = "\\d+";
    public static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "구입 금액은 음수이면 안됩니다.";
    public static final String LIMIT_EXCEEDED_MESSAGE = "로또 구입 금액은 10만 원을 초과할 수 없습니다.";
    public static final BigDecimal MAX_PURCHASE_AMOUNT_TEN_THOUSAND = BigDecimal.valueOf(100_000);
}
