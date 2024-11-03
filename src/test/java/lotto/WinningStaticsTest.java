package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStaticsTest {
    private WinningStatics winningStatics;

    @BeforeEach
    void setUp() {
        winningStatics = new WinningStatics();
    }

    @Test
    @DisplayName("당첨 되는 경우(1등 1개) 수익률이 1등 상금과 일치한다.")
    void 당첨_되는_경우_수익률이_1등_상금과_일치한다() {
        winningStatics.winFirst();

        assertThat(winningStatics.getFirst()).isEqualTo(1);
        assertThat(winningStatics.getRateOfReturn(1))
                .isEqualTo((double) WinningStatics.FIRST_PLACE_PRIZE / Lotto.LOTTO_PRICE * 100);
    }

    @Test
    @DisplayName("당첨 되는 경우(2등 1개) 수익률이 2등 상금과 일치한다.")
    void 당첨_되는_경우_수익률이_2등_상금과_일치한다() {
        winningStatics.winSecond();

        assertThat(winningStatics.getSecond()).isEqualTo(1);
        assertThat(winningStatics.getRateOfReturn(1))
                .isEqualTo((double) WinningStatics.SECOND_PLACE_PRIZE / Lotto.LOTTO_PRICE * 100);
    }

    @Test
    @DisplayName("당첨 되는 경우(3등 1개) 수익률이 3등 상금과 일치한다.")
    void 당첨_되는_경우_수익률이_3등_상금과_일치한다() {
        winningStatics.winThird();

        assertThat(winningStatics.getThird()).isEqualTo(1);
        assertThat(winningStatics.getRateOfReturn(1))
                .isEqualTo((double) WinningStatics.THIRD_PLACE_PRIZE / Lotto.LOTTO_PRICE * 100);
    }

    @Test
    @DisplayName("당첨 되는 경우(4등 1개) 수익률이 4등 상금과 일치한다.")
    void 당첨_되는_경우_수익률이_4등_상금과_일치한다() {
        winningStatics.winFourth();

        assertThat(winningStatics.getFourth()).isEqualTo(1);
        assertThat(winningStatics.getRateOfReturn(1))
                .isEqualTo((double) WinningStatics.FOURTH_PLACE_PRIZE / Lotto.LOTTO_PRICE * 100);
    }

    @Test
    @DisplayName("당첨 되는 경우(5등 1개) 수익률이 5등 상금과 일치한다.")
    void 당첨_되는_경우_수익률이_5등_상금과_일치한다() {
        winningStatics.winFifth();

        assertThat(winningStatics.getFifth()).isEqualTo(1);
        assertThat(winningStatics.getRateOfReturn(1))
                .isEqualTo((double) WinningStatics.FIFTH_PLACE_PRIZE / Lotto.LOTTO_PRICE * 100);
    }

    @Test
    @DisplayName("당첨 되는 경우(1등 1개, 3등 1개, 5등 1개) 기록하고 총 수익률 계산한다.")
    void 당첨_되는_경우_기록하고_총_수익률_계산한다() {
        winningStatics.winFirst();
        winningStatics.winThird();
        winningStatics.winFifth();

        int count = 5;
        double expectedWinnings = WinningStatics.FIRST_PLACE_PRIZE +
                WinningStatics.THIRD_PLACE_PRIZE +
                WinningStatics.FIFTH_PLACE_PRIZE;
        double expectedRateOfReturn = (expectedWinnings / (count * Lotto.LOTTO_PRICE)) * 100;

        assertThat(winningStatics.getRateOfReturn(count)).isEqualTo(expectedRateOfReturn);
    }
}