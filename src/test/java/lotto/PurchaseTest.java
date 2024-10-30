package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {
    @DisplayName("구입 금액이 숫자가 아닌 입력이라면 예외가 발생한다")
    @Test
    void 구입_금액_숫자_검증_테스트() {
        assertThatThrownBy(() -> new Purchase("천원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 0이라면 예외가 발생한다")
    @Test
    void 구입_금액_0_검증_테스트() {
        assertThatThrownBy(() -> new Purchase("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 천원단위가 아니라면 예외가 발생한다")
    @Test
    void 구입_금액_천원_단위_검증_테스트() {
        assertThatThrownBy(() -> new Purchase("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
