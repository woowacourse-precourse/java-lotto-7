package lotto.business;

import lotto.MyException;

public enum BusinessException implements MyException {
    NEGATIVE_MONEY("금액은 0 이상이어야 합니다.", IllegalArgumentException.class),
    INVALID_MONEY_UNIT("금액은 1,000원 단위로 입력해야 합니다.", IllegalArgumentException.class),
    INVALID_MONEY_FOR_PURCHASE("로또 구매에 거스름돈을 지원하지 않습니다.", IllegalArgumentException.class),
    ;

    private static final String MESSAGE_PREFIX = "[ERROR] ";

    private final String message;
    private final Class<? extends RuntimeException> exceptionClass;

    BusinessException(String message, Class<? extends RuntimeException> exceptionClass) {
        this.message = message;
        this.exceptionClass = exceptionClass;
    }

    @Override
    public RuntimeException getException() {
        try {
            return exceptionClass.getDeclaredConstructor(String.class).newInstance(MESSAGE_PREFIX + message);
        } catch (ReflectiveOperationException ignored) {
            throw new RuntimeException(MESSAGE_PREFIX + "예외를 생성할 수 없습니다.");
        }
    }
}
