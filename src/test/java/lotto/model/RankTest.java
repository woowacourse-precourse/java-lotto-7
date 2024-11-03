package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @Test
    @DisplayName("매칭된 숫자 개수와 보너스 숫자 매치 여부에 따라 올바른 Rank가 할당된다.")
    void matchingRank() {
        assertThat(Rank.matchingRank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.matchingRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.matchingRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.matchingRank(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.matchingRank(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("각 Rank에 해당하는 상금을 반환한다.")
    void getPrize() {
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000);
    }

    @Test
    @DisplayName("할당된 Rank를 기준으로 결과를 출력 형식에 맞게 출력한다.")
    void displayRankResult() {
        assertThat(Rank.FIRST.displayRankResult(1)).isEqualTo("6개 일치 (2,000,000,000원) - 1개");
        assertThat(Rank.SECOND.displayRankResult(2)).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원) - 2개");
        assertThat(Rank.THIRD.displayRankResult(0)).isEqualTo("5개 일치 (1,500,000원) - 0개");
        assertThat(Rank.FOURTH.displayRankResult(3)).isEqualTo("4개 일치 (50,000원) - 3개");
        assertThat(Rank.FIFTH.displayRankResult(5)).isEqualTo("3개 일치 (5,000원) - 5개");
    }
}
