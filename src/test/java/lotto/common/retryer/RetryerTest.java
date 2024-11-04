package lotto.common.retryer;

import lotto.common.exception.CustomException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Retryer 테스트")
public class RetryerTest {

    private static int threshold = 3;
    private static int count = 0;

    @BeforeAll
    static void setUp() {
        threshold = 3;
    }

    @Test
    @DisplayName("예외 발생 시 반환값 있는 메서드를 재실행한다")
    void 예외_발생_시_반환값_있는_메서드를_재실행한다() {

        // when
        Retryer.retryOnCustomException(this::throwExceptionUntilThresholdObject);

        // then
        assertThat(isThresholdReached()).isTrue();
    }

    @Test
    @DisplayName("예외 발생 시 반환값 없는 메서드를 재실행한다")
    void 예외_발생_시_반환값_없는_메서드를_재실행한다() {

        // when
        Retryer.retryOnCustomException(this::throwExceptionUntilThresholdVoid);

        // then
        assertThat(isThresholdReached()).isTrue();
    }

    private void throwExceptionUntilThresholdVoid() {
        if (isThresholdReached()) {
            return;
        }
        increaseCount();
        throw new TestCustomException();
    }

    private Object throwExceptionUntilThresholdObject() {
        if (isThresholdReached()) {
            return new Object();
        }
        increaseCount();
        throw new TestCustomException();
    }

    private boolean isThresholdReached() {
        return count == threshold;
    }

    private void increaseCount() {
        count++;
    }

    private static class TestCustomException extends RuntimeException implements CustomException {

        public TestCustomException() {
            super("TestCustomException 예외 발생");
        }
    }
}
