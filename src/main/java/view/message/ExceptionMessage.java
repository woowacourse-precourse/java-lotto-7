package view.message;

import java.math.BigDecimal;

public class ExceptionMessage {

    public static final String BANK_EXCEPTION_MESSAGE = "입력값이 빈 공백이거나 비어있으면 안 됩니다.";
    public static final String NUMBER_EXCEPTION_MESSAGE = "입력값은 숫자여야 합니다.";
    public static final String NUMBER_REGEX = "\\d+";
    public static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "구입 금액은 음수이면 안됩니다.";
    public static final String LIMIT_EXCEED_EXCEPTION_MESSAGE = "로또 구입 금액은 10만 원을 초과할 수 없습니다.";
    public static final BigDecimal MAX_PURCHASE_AMOUNT_TEN_THOUSAND = BigDecimal.valueOf(100_000);
    public static final BigDecimal THOUSAND_UNIT = BigDecimal.valueOf(1_000);
    public static final String INVALID_UNIT_EXCEPTION_MESSAGE = "구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String LOTTO_NUMBERS_COUNT_EXCEPTION_MESSAGE = "로또 번호는 6개 입력해야 합니다.";
    public static final String LOTTO_NUMBER_RANGE_EXCEPTION_MESSAGE = "로또 번호는 1 이상 45 이하의 값을 입력해야 합니다.";
}
