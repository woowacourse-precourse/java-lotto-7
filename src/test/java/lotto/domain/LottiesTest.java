package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottiesTest {

    @ParameterizedTest
    @ValueSource(ints = {999, 6_999, 1_001, 6_001, 5_500})
    void validateTest_whenPriceNotDivideByUnitPrice_throwException(int price) {
        assertThatThrownBy(() -> Lotties.from(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또의 가격은 1000 단위여야 합니다");
    }

    @ParameterizedTest
    @ValueSource(ints = {1_000, 6_000, 50_000})
    void validateTest_whenPriceDivideByUnitPrice(int price) {
        assertThatCode(() -> Lotties.from(price))
                .doesNotThrowAnyException();
    }
}
