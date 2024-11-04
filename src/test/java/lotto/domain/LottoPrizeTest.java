package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {
    @DisplayName("등수별 당첨금을 확인한다")
    @Test
    void getPrizeByRank() {
        assertThat(LottoPrize.getPrize(1)).isEqualTo(2_000_000_000);
        assertThat(LottoPrize.getPrize(2)).isEqualTo(30_000_000);
        assertThat(LottoPrize.getPrize(3)).isEqualTo(1_500_000);
        assertThat(LottoPrize.getPrize(4)).isEqualTo(50_000);
        assertThat(LottoPrize.getPrize(5)).isEqualTo(5_000);
    }
}