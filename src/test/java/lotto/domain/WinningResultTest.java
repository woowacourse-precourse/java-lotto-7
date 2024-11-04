package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {

    @Test
    void 매치_카운트와_보너스로_당첨_결과를_찾는다() {
        assertThat(WinningResult.findByMatchCountAndBonus(3, false)).isEqualTo(WinningResult.RANK_5TH);
        assertThat(WinningResult.findByMatchCountAndBonus(4, false)).isEqualTo(WinningResult.RANK_4TH);
        assertThat(WinningResult.findByMatchCountAndBonus(5, false)).isEqualTo(WinningResult.RANK_3TH);
        assertThat(WinningResult.findByMatchCountAndBonus(5, true)).isEqualTo(WinningResult.RANK_2TH);
        assertThat(WinningResult.findByMatchCountAndBonus(6, false)).isEqualTo(WinningResult.RANK_1TH);
        assertThat(WinningResult.findByMatchCountAndBonus(2, false)).isEqualTo(WinningResult.NONE);
    }

    @Test
    void 당첨_금액을_계산한다() {
        assertThat(WinningResult.RANK_5TH.calculateTotalWinningAmount(3)).isEqualTo(15_000);
        assertThat(WinningResult.RANK_1TH.calculateTotalWinningAmount(1)).isEqualTo(2_000_000_000);
    }

    @Test
    void 포맷된_결과를_반환한다() {
        Map<WinningResult, Integer> winningResult = Map.of(
                WinningResult.RANK_5TH, 3,
                WinningResult.RANK_4TH, 1
        );
        assertThat(WinningResult.getFormattedResults(winningResult)).containsExactly(
                "4개 일치 (50,000원) - 1개",
                "3개 일치 (5,000원) - 3개"
        );
    }
}