package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BuyTest {

    @DisplayName("1000원 미만의 금액으로 로또를 구매하려고 하면 예외가 발생한다.")
    @Test
    void 금액이_1000원_미만이면_예외가_발생한다() {
        Buy buy = new Buy();
        assertThatThrownBy(() -> buy.countLotto(500))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 구매금액은 1000원 이상이어야 합니다.");
    }

    @DisplayName("1000원 단위가 아닌 금액으로 로또를 구매하려고 하면 예외가 발생한다.")
    @Test
    void 금액이_1000원_단위가_아니면_예외가_발생한다() {
        Buy buy = new Buy();
        assertThatThrownBy(() -> buy.countLotto(7500))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 구매금액은 1000원 단위로 가능합니다.");
    }

    @DisplayName("유효한 금액으로 로또를 구매할 때 로또 개수를 반환한다.")
    @Test
    void 유효한_금액으로_로또를_구매할_때_개수를_반환한다() {
        Buy buy = new Buy();
        assertThat(buy.countLotto(8000)).isEqualTo(8);
    }
}
