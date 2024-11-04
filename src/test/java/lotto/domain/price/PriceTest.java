package lotto.domain.price;

import static lotto.support.utils.CustomExceptionAssertions.assertCustomIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.math.BigDecimal;
import lotto.domain.quantity.Quantity;
import lotto.exception.argument.price.InvalidPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("구입 금액 테스트")
public class PriceTest {

    @Nested
    @DisplayName("생성 테스트")
    class 생성_테스트 {
        @Test
        @DisplayName("구입 금액을 생성한다.")
        void 성공_생성() {
            // Given

            // When & Then
            assertThatCode(() -> {
                new Price(new BigDecimal(Long.MAX_VALUE + "000"));
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("구입 금액이 실수일 경우 예외가 발생한다.")
        void 실패_생성_실수() {
            // Given

            // When & Then
            assertCustomIllegalArgumentException(() -> new Price(new BigDecimal("10.12")))
                    .isExactlyInstanceOf(InvalidPriceException.class)
                    .hasMessageContaining("구입 금액은 숫자로만 이루어져야 합니다.");
        }

        @Test
        @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
        void 실패_생성_1000원단위아님() {
            // Given

            // When & Then
            assertCustomIllegalArgumentException(() -> new Price(BigDecimal.valueOf(500)))
                    .isExactlyInstanceOf(InvalidPriceException.class)
                    .hasMessageContaining("구입 금액이 1000원 단위가 아닙니다.");
        }

        @ParameterizedTest
        @ValueSource(strings = {"0", "-1000"})
        @DisplayName("구입 금액이 자연수가 아닐 경우 예외가 발생한다.")
        void 실패_생성_자연수아님(String input) {
            // Given

            // When & Then
            assertCustomIllegalArgumentException(() -> new Price(new BigDecimal(input)))
                    .isExactlyInstanceOf(InvalidPriceException.class)
                    .hasMessageContaining("구입 금액은 자연수여야 합니다.");
        }
    }

    @Nested
    @DisplayName("로또 수량 계산 테스트")
    class 로또_수량_계산_테스트 {

        @Test
        @DisplayName("로또 수량을 계산한다.")
        void 성공_로또수량계산() {
            // Given
            Price price = new Price(BigDecimal.valueOf(10000));

            // When
            Quantity quantity = price.calculateQuantity();

            // Then
            assertThat(quantity).isEqualTo(new Quantity(BigDecimal.TEN));
        }
    }

}
