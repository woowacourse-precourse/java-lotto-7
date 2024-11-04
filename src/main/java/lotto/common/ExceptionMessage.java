package lotto.common;

public final class ExceptionMessage {

    private static final String EXCEPTION_PREFIX = "[ERROR] ";
    public static final String OUT_OF_RANGE_NUMBER = EXCEPTION_PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    public static final String NO_OVERLAP_NUMBER = EXCEPTION_PREFIX + "당첨 번호와 보너스 번호는 겹치면 안됩니다.";
    private ExceptionMessage() {

    }
}
