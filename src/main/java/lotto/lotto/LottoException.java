package lotto.lotto;

import lotto.MyException;

public enum LottoException implements MyException {
    INVALID_NUMBER_SIZE("로또 번호의 개수는 6개여야 합니다.", IllegalArgumentException.class),
    DUPLICATED_NUMBER("로또 번호에 중복된 숫자가 있습니다.", IllegalArgumentException.class),
    INVALID_NUMBER("로또 번호는 1에서 45 사이의 숫자여야 합니다.", IllegalArgumentException.class),
    COMMON_BETWEEN_WINNING_NUMBER_AND_BONUS_NUMBER("당첨 번호와 보너스 번호는 중복될 수 없습니다.", IllegalArgumentException.class),
    ;

    private static final String MESSAGE_PREFIX = "[ERROR] ";

    private final String message;
    private final Class<? extends RuntimeException> exceptionClass;

    LottoException(String message, Class<? extends RuntimeException> exceptionClass) {
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
