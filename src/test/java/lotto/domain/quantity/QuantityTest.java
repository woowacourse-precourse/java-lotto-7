package lotto.domain.quantity;

import static lotto.support.utils.CustomExceptionAssertions.assertCustomIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.math.BigDecimal;
import java.util.stream.Stream;
import lotto.exception.argument.quantity.InvalidQuantityException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 수량 테스트")
class QuantityTest {

    @Nested
    class 생성_테스트 {

        @Test
        @DisplayName("로또 수량을 생성한다.")
        void 성공_생성() {
            // Given

            // When & Then
            assertThatCode(() -> {
                new Quantity(BigDecimal.TEN);
            }).doesNotThrowAnyException();
        }

        @ParameterizedTest
        @MethodSource
        @DisplayName("로또 수량이 자연수가 아닐 경우 실패한다.")
        void 실패_생성_자연수X(BigDecimal quantity) {
            // Given

            // When & Then
            assertCustomIllegalArgumentException(() -> new Quantity(quantity))
                    .isExactlyInstanceOf(InvalidQuantityException.class)
                    .hasMessageContaining("수량은 자연수여야 합니다.");
        }

        private static Stream<Arguments> 실패_생성_자연수X() {
            return Stream.of(
                    Arguments.of(BigDecimal.ZERO),
                    Arguments.of(BigDecimal.valueOf(-1)),
                    Arguments.of(BigDecimal.valueOf(-1.3))
            );
        }
    }
}
