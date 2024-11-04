package lotto.function.purchase.processor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.util.calculator.PurchasableCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PurchasableCountCalculateProcessorTest {

    PurchasableCountCalculateProcessor purchasableCountCalculateProcessor;

    @BeforeEach
    void setUp() {
        purchasableCountCalculateProcessor = new PurchasableCountCalculateProcessor(
                new PurchasableCalculator());
    }

    @ParameterizedTest
    @MethodSource("calculatePurchasableCount")
    void 구입_금액을_계산하면_구입_가능한_개수를_반환한다(int purchaseAmount, int expectedCount) {
        int purchasableCount =
                purchasableCountCalculateProcessor.calculatePurchasableCount(purchaseAmount);
        assertThat(purchasableCount).isEqualTo(expectedCount);
    }

    public static Stream<Arguments> calculatePurchasableCount() {
        return Stream.of(
                Arguments.of(1000, 1),
                Arguments.of(14000, 14),
                Arguments.of(999000, 999)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 100, 999, -1})
    void 구입_가능한_개수가_한_개_미만이라면_예외가_발생한다(int purchaseAmount) {
        assertThatThrownBy(() ->
                purchasableCountCalculateProcessor.calculatePurchasableCount(purchaseAmount)
        )
                .isInstanceOf(IllegalArgumentException.class);
    }

}