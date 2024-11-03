package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyManagerTest {

    @Test
    void 수익률_반환() {
        MoneyManager moneyManager = new MoneyManager(10000L);
        moneyManager.setPrizeMoney(50000L);

        assertThat(moneyManager.getReturnRate()).isEqualTo(500);
    }

    @Test
    void 구매_금액_천원_단위가_아니면_예외_발생() {
        assertThatThrownBy(() -> new MoneyManager(11111L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매_금액_음수면_예외_발생() {
        assertThatThrownBy(() -> new MoneyManager(-10000L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 상금_입력_전_수익률_계산하면_예외_발생() {
        MoneyManager moneyManager = new MoneyManager(10000L);

        assertThatThrownBy(moneyManager::getReturnRate)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
