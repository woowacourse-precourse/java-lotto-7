package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("일치 개수와 보너스 일치 여부에 따라 올바른 Rank를 반환한다")
    void 일치_개수와_보너스_여부에_따른_Rank_반환() {
        assertThat(Rank.getRank(6, false)).isEqualTo(Rank.SIX_MATCH);
        assertThat(Rank.getRank(5, true)).isEqualTo(Rank.FIVE_MATCH_BONUS);
        assertThat(Rank.getRank(5, false)).isEqualTo(Rank.FIVE_MATCH);
        assertThat(Rank.getRank(4, false)).isEqualTo(Rank.FOUR_MATCH);
        assertThat(Rank.getRank(3, false)).isEqualTo(Rank.THREE_MATCH);
        assertThat(Rank.getRank(2, false)).isNull();
    }

    @Test
    @DisplayName("Rank의 상금이 올바르게 반환된다")
    void Rank의_상금이_올바르게_반환된다() {
        assertThat(Rank.THREE_MATCH.getPrize()).isEqualTo(5000);
        assertThat(Rank.FOUR_MATCH.getPrize()).isEqualTo(50000);
        assertThat(Rank.FIVE_MATCH.getPrize()).isEqualTo(1500000);
        assertThat(Rank.FIVE_MATCH_BONUS.getPrize()).isEqualTo(30000000);
        assertThat(Rank.SIX_MATCH.getPrize()).isEqualTo(2000000000);
    }

    @Test
    @DisplayName("Rank Enum의 toString이 displayName을 올바르게 반환한다")
    void Rank_toString_확인() {
        assertThat(Rank.THREE_MATCH.toString()).isEqualTo("3개 일치 (5,000원)");
        assertThat(Rank.FOUR_MATCH.toString()).isEqualTo("4개 일치 (50,000원)");
        assertThat(Rank.FIVE_MATCH.toString()).isEqualTo("5개 일치 (1,500,000원)");
        assertThat(Rank.FIVE_MATCH_BONUS.toString()).isEqualTo("5개 일치, 보너스 볼 일치 (30,000,000원)");
        assertThat(Rank.SIX_MATCH.toString()).isEqualTo("6개 일치 (2,000,000,000원)");
    }
}
