package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class YieldCalculatorTest {

    @DisplayName("수익률이 정확하게 계산된다.")
    @Test
    void 정확한_수익률을_계산한다() {
        MyWallet myWallet = new MyWallet();
        myWallet.saveMoney(10000);
        myWallet.saveWinnings(5000);

        double yield = YieldCalculator.calculateYield(myWallet);

        assertThat(yield).isEqualTo(50.0f);
    }

    @DisplayName("수익이 없는 경우 수익률은 0%가 된다.")
    @Test
    void 수익이_없는_경우_수익률은_0퍼센트() {
        MyWallet myWallet = new MyWallet();
        myWallet.saveMoney(10000);
        myWallet.saveWinnings(0);

        double yield = YieldCalculator.calculateYield(myWallet);

        assertThat(yield).isEqualTo(0.0f);
    }

    @DisplayName("투자금이 0일 때 수익률 계산 시 예외가 발생한다.")
    @Test
    void 투자금이_0일_때_예외가_발생한다() {
        MyWallet myWallet = new MyWallet();
        myWallet.saveMoney(0);
        myWallet.saveWinnings(5000);

        assertThatThrownBy(() -> YieldCalculator.calculateYield(myWallet))
                .isInstanceOf(IllegalStateException.class);
    }
}
