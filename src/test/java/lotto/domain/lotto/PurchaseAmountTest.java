package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @DisplayName("구매 금액은 1,000원 단위의 100,000원 이하의 금액이다.")
    @ValueSource(longs = {1_000L, 100_000L})
    @ParameterizedTest
    void 구매_금액_생성_성공(long purchaseAmountInput) {
        assertDoesNotThrow(() -> new PurchaseAmount(purchaseAmountInput));
    }

    @DisplayName("구매 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구매_금액은_천원_단위가_아니면_예외_발생() {
        assertThatThrownBy(() -> new PurchaseAmount(1100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("구입금액");
    }

    @DisplayName("구매 금액의 범위 1,000원~100,000원을 벗어나면 예외가 발생한다.")
    @ValueSource(longs = {0L, 101_000L})
    @ParameterizedTest
    void 구매_금액은_범위를_벗어나면_예외_발생(long purchaseAmountInput) {
        assertThatThrownBy(() -> new PurchaseAmount(purchaseAmountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("[ERROR]")
                .hasMessageContaining("구입금액");
    }

}
