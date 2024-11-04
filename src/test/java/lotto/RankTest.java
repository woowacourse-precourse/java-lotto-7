package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import lotto.model.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {

    @DisplayName("로또번호 일치 여부 별 등수")
    @Test
    void 로또번호_일치_여부_별_등수() {
        assertThat(Rank.getMatchedRank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getMatchedRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getMatchedRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getMatchedRank(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getMatchedRank(3, false)).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("로또등수 별 상금")
    @Test
    void 로또등수_별_상금() {
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2000000000);
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30000000);
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1500000);
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50000);
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5000);
    }
}
