package lotto.support.utils;

import static lotto.exception.constants.ExceptionMessage.ERROR_PREFIX;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.ThrowableAssert;

public class CustomExceptionAssertions {
    public static AbstractThrowableAssert<?, ? extends Throwable> assertCustomIllegalArgumentException(
            ThrowableAssert.ThrowingCallable throwingCallable) {
        return assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_PREFIX.getMessage());
    }

    public static AbstractThrowableAssert<?, ? extends Throwable> assertCustomIllegalStateException(
            ThrowableAssert.ThrowingCallable throwingCallable) {
        return assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageStartingWith(ERROR_PREFIX.getMessage());
    }
}
