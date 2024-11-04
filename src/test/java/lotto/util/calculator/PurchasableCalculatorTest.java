package lotto.util.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PurchasableCalculatorTest {

    PurchasableCalculator purchasableCalculator;

    @BeforeEach
    void setUp() {
        purchasableCalculator = new PurchasableCalculator();
    }

    @ParameterizedTest
    @MethodSource("calculatePurchasableCount")
    void 구입_금액과_상품의_가격을_입력하면_구입_가능한_개수를_계산한다(int purchaseAmount, int unitPrice, int expected) {
        int purchasableCount = purchasableCalculator.calculatePurchasableCount(purchaseAmount,
                unitPrice);
        assertThat(purchasableCount).isEqualTo(expected);
    }

    public static Stream<Arguments> calculatePurchasableCount() {
        return Stream.of(
                Arguments.of(1000, 1000, 1),
                Arguments.of(10000, 1000, 10),
                Arguments.of(1000, 1, 1000)
        );
    }

    @ParameterizedTest
    @MethodSource("calculatePurchasableCountWithNoMultipleAmount")
    void 구입_금액이_상품_가격보다_작으면_예외가_발생한다(int purchaseAmount, int unitPrice) {
        assertThatThrownBy(
                () -> purchasableCalculator.calculatePurchasableCount(purchaseAmount, unitPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public static Stream<Arguments> calculatePurchasableCountWithNoMultipleAmount() {
        return Stream.of(
                Arguments.of(1000, 10000),
                Arguments.of(1, 2),
                Arguments.of(0, 1000)
        );
    }

}