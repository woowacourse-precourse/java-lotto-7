package lotto.io;

import lotto.MyException;

public enum IOException implements MyException {
    CANNOT_PARSE_TO_INTEGER("정수로 변환할 수 없는 문자열입니다.", NumberFormatException.class),
    ;

    private static final String MESSAGE_PREFIX = "[ERROR] ";

    private final String message;
    private final Class<? extends RuntimeException> exceptionClass;

    IOException(String message, Class<? extends RuntimeException> exceptionClass) {
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
