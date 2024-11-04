package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingTest {

    @Test
    @DisplayName("당첨 번호 일치 개수와 보너스 번호 일치 여부를 통해서 당첨 등수를 구한다.")
    void findWinningRankTest() {
        Ranking winningRank1 = Ranking.findRanking(0, false);
        Ranking winningRank2 = Ranking.findRanking(1, false);
        Ranking winningRank3 = Ranking.findRanking(2, false);
        Ranking winningRank4 = Ranking.findRanking(3, false);
        Ranking winningRank5 = Ranking.findRanking(4, false);
        Ranking winningRank6 = Ranking.findRanking(5, false);
        Ranking winningRank7 = Ranking.findRanking(5, true);
        Ranking winningRank8 = Ranking.findRanking(6, false);

        assertThat(winningRank1).isEqualTo(Ranking.LAST_PLACE);
        assertThat(winningRank2).isEqualTo(Ranking.LAST_PLACE);
        assertThat(winningRank3).isEqualTo(Ranking.LAST_PLACE);
        assertThat(winningRank4).isEqualTo(Ranking.FIFTH_PLACE);
        assertThat(winningRank5).isEqualTo(Ranking.FOURTH_PLACE);
        assertThat(winningRank6).isEqualTo(Ranking.THIRD_PLACE);
        assertThat(winningRank7).isEqualTo(Ranking.SECOND_PLACE);
        assertThat(winningRank8).isEqualTo(Ranking.FIRST_PLACE);
    }
}
