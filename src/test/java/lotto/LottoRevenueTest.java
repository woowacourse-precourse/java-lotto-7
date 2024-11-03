package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoRevenueTest {

    @DisplayName("로또 수익률을 올바르게 계산한다.")
    @Test
    void calculateRevenueRate_수익률을_올바르게_계산한다() {
        double revenueRate = LottoRevenue.calculateRevenueRate(10000, 5000);
        assertThat(revenueRate).isEqualTo(50.0);

        revenueRate = LottoRevenue.calculateRevenueRate(20000, 6000);
        assertThat(revenueRate).isEqualTo(30.0);

        revenueRate = LottoRevenue.calculateRevenueRate(30000, 7500);
        assertThat(revenueRate).isEqualTo(25.0);

        revenueRate = LottoRevenue.calculateRevenueRate(10000, 10000);
        assertThat(revenueRate).isEqualTo(100.0);
    }

    @DisplayName("로또 수익률 계산 시 0으로 나누는 경우 예외가 발생한다.")
    @Test
    void calculateRevenueRate_0으로_나누는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoRevenue.calculateRevenueRate(0, 5000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 비용은 0보다 커야 합니다.");
    }

    @DisplayName("로또 수익률 계산 시 음수로 나누는 경우 예외가 발생한다.")
    @Test
    void calculateRevenueRate_음수로_나누는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> LottoRevenue.calculateRevenueRate(-1000, 5000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 비용은 0보다 커야 합니다.");
    }
}
