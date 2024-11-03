package lotto.exception;

public class NullParameterException extends IllegalArgumentException {

    private static final String MESSAGE = "%s에 전달된 파라미터가 null입니다.";

    public NullParameterException(Class<?> caller) {
        super(String.format(MESSAGE, caller.getSimpleName()));
    }
}
