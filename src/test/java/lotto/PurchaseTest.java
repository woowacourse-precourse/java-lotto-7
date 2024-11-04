package lotto;

import lotto.model.Purchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {
    @DisplayName("구입금액이 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {999, 1_001, 100_001})
    void 구입금액이_1000으로_나누어_떨어지지_않으면_예외가_발생한다(int price) {
        assertThatThrownBy(() -> new Purchase(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입금액이 1000원 이상 100000원 이하가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 999, 100_001})
    void 구입금액이_1000원_이상_100000원_이하가_아니면_예외가_발생한다(int price) {
        assertThatThrownBy(() -> new Purchase(price))
                .isInstanceOf(IllegalArgumentException.class);
    }
}