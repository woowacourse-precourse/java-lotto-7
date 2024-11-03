package lotto.domain.price;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import lotto.domain.quantity.Quantity;
import lotto.exception.price.InvalidPurchasePriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("구입 금액 테스트")
public class PurchasePriceTest {

    @Nested
    @DisplayName("생성 테스트")
    class 생성_테스트 {
        @Test
        @DisplayName("구입 금액을 생성한다")
        void 성공_생성() {
            // Given

            // When & Then
            assertThatCode(() -> {
                new PurchasePrice(Long.MAX_VALUE + "000");
            }).doesNotThrowAnyException();
        }

        @ParameterizedTest
        @ValueSource(strings = {" 1000", "1000 "})
        @DisplayName("구입 금액 처음이나 끝에 공백이 포함될 경우 공백을 무시하고 생성한다")
        void 성공_생성_처음이나끝에공백포함(String input) {
            // Given

            // When & Then
            assertThatCode(() -> {
                new PurchasePrice(input);
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다")
        void 실패_생성_1000원단위아님() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new PurchasePrice("500"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidPurchasePriceException.class)
                    .hasMessageContaining("구입 금액이 1000원 단위가 아닙니다");
        }

        @ParameterizedTest
        @ValueSource(strings = {"a20", "1000.0", "1000 0"})
        @DisplayName("구입 금액이 정수가 아닐 경우 예외가 발생한다")
        void 실패_생성_정수X(String input) {
            // Given

            // When & Then
            assertThatThrownBy(() -> new PurchasePrice(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidPurchasePriceException.class)
                    .hasMessageContaining("구입 금액은 숫자로만 이루어져야 합니다");
        }

        @ParameterizedTest
        @ValueSource(strings = {"0", "-1000"})
        @DisplayName("구입 금액이 자연수가 아닐 경우 예외가 발생한다")
        void 실패_생성_자연수아님(String input) {
            // Given

            // When & Then
            assertThatThrownBy(() -> new PurchasePrice(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidPurchasePriceException.class)
                    .hasMessageContaining("구입 금액은 자연수여야 합니다");
        }

        @Test
        @DisplayName("구입 금액이 비어있을 경우 예외가 발생한다")
        void 실패_생성_empty() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new PurchasePrice(""))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidPurchasePriceException.class)
                    .hasMessageContaining("구입 금액은 비어있거나 공백일 수 없습니다");
        }

        @Test
        @DisplayName("구입 금액이 공백일 경우 예외가 발생한다")
        void 실패_생성_공백() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new PurchasePrice(" "))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidPurchasePriceException.class)
                    .hasMessageContaining("구입 금액은 비어있거나 공백일 수 없습니다");
        }

        @Test
        @DisplayName("구입 금액이 null일 경우 예외가 발생한다")
        void 실패_생성_null() {
            // Given

            // When & Then
            assertThatThrownBy(() -> new PurchasePrice(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .isExactlyInstanceOf(InvalidPurchasePriceException.class)
                    .hasMessageContaining("구입 금액은 null이 될 수 없습니다");
        }
    }

    @Nested
    @DisplayName("로또 수량 계산 테스트")
    class 로또_수량_계산_테스트 {

        @Test
        @DisplayName("로또 수량을 계산한다")
        void 성공_로또수량계산() {
            // Given
            PurchasePrice price = new PurchasePrice("10000");

            // When
            Quantity quantity = price.calculateQuantity();

            // Then
            assertThat(quantity).isEqualTo(new Quantity(BigDecimal.TEN));
        }
    }

}
