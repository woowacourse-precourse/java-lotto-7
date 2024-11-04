package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetryUtilTest {

    @Test
    @DisplayName("예외 없이 값을 정상적으로 반환한다")
    void 예외_없이_값을_정상적으로_반환한다() {
        // given
        String expectedResult = "Success";

        // when
        String result = RetryUtil.retryOnError(() -> expectedResult);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("예외 발생 후 지정된 횟수만큼 재시도하여 값을 반환한다")
    void 예외_발생_후_지정된_횟수만큼_재시도하여_값을_반환한다() {
        // given
        int[] attempts = {0};
        String expectedResult = "Success";

        // when
        String result = RetryUtil.retryOnError(() -> {
            if (attempts[0] < 2) {
                attempts[0]++;
                throw new IllegalArgumentException("Failure");
            }
            return expectedResult;
        });

        // then
        assertThat(result).isEqualTo(expectedResult);
        assertThat(attempts[0]).isEqualTo(2);
    }

    @Test
    @DisplayName("최대 재시도 횟수를 초과하면 예외를 발생시킨다")
    void 최대_재시도_횟수를_초과하면_예외를_발생시킨다() {
        // given
        int maxRetries = 3;
        int[] attempts = {0};

        // when & then
        assertThatThrownBy(() -> RetryUtil.retryOnError(() -> {
            attempts[0]++;
            throw new IllegalArgumentException("Failure");
        }, maxRetries))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.EXCEEDED_MAXIMUM_RETRY_ATTEMPTS.getMessage());

        assertThat(attempts[0]).isEqualTo(maxRetries);
    }
}
