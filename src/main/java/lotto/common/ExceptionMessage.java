package lotto.common;

public final class ExceptionMessage {

    public static final String EXCEPTION_PREFIX = "[ERROR] ";
    public static final String OUT_OF_RANGE_NUMBER = "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String NO_OVERLAP_NUMBER = "당첨 번호와 보너스 번호는 겹치면 안됩니다.";
    public static final String LOTTO_NUMBER_OUT_SIZE = "로또 번호는 6개여야 합니다.";
    public static final String NO_LOTTO_NUMBER_DUPLICATION = "로또 번호가 중복되서는 안됩니다.";
    public static final String MONEY_MUST_POSITIVE = "입력 금액은 양의 정수여야 합니다.";
    public static final String FOLLOW_MONEY_UNIT = "입력 금액은 로또 가격에 나누어 떨어져야합니다.";
    public static final String NO_NUMBER_FORMAT = "숫자 형식이 올바르지 않습니다.";

    private ExceptionMessage() {

    }
}
