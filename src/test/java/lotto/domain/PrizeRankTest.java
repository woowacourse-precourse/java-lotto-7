package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeRankTest {
    @Test
    @DisplayName("일치하는 번호 개수와 보너스 번호 일치 여부로 당첨 등수를 구한다")
    void findByMatchCount() {
        assertThat(PrizeRank.findByMatch(6, false)).isEqualTo(PrizeRank.FIRST);
        assertThat(PrizeRank.findByMatch(5, true)).isEqualTo(PrizeRank.SECOND);
        assertThat(PrizeRank.findByMatch(5, false)).isEqualTo(PrizeRank.THIRD);
        assertThat(PrizeRank.findByMatch(4, false)).isEqualTo(PrizeRank.FOURTH);
        assertThat(PrizeRank.findByMatch(3, false)).isEqualTo(PrizeRank.FIFTH);
        assertThat(PrizeRank.findByMatch(2, false)).isEqualTo(PrizeRank.NONE);
    }

    @Test
    @DisplayName("당첨금 계산이 정확해야 한다")
    void getPrizeMoney() {
        assertThat(PrizeRank.FIRST.getPrizeMoney()).isEqualTo(2_000_000_000);
        assertThat(PrizeRank.SECOND.getPrizeMoney()).isEqualTo(30_000_000);
        assertThat(PrizeRank.THIRD.getPrizeMoney()).isEqualTo(1_500_000);
        assertThat(PrizeRank.FOURTH.getPrizeMoney()).isEqualTo(50_000);
        assertThat(PrizeRank.FIFTH.getPrizeMoney()).isEqualTo(5_000);
        assertThat(PrizeRank.NONE.getPrizeMoney()).isEqualTo(0);
    }
}
