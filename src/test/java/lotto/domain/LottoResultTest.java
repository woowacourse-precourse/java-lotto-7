package lotto.domain;

import lotto.constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
    }

    @DisplayName("당첨 순위 기록 시 당첨 횟수가 올바르게 증가하고, 총 상금이 올바르게 계산된다.")
    @Test
    void 당첨_순위_기록_및_총_상금_계산_테스트() {
        lottoResult.recordMatch(Rank.SIX_MATCH);
        lottoResult.recordMatch(Rank.SIX_MATCH);
        lottoResult.recordMatch(Rank.FIVE_MATCH);

        assertThat(lottoResult.getWinningCount().get(Rank.SIX_MATCH)).isEqualTo(2);
        assertThat(lottoResult.getWinningCount().get(Rank.FIVE_MATCH)).isEqualTo(1);
        assertThat(lottoResult.getWinningCount().get(Rank.FIVE_MATCH_BONUS)).isEqualTo(0);

        long expectedTotalWinnings = (Rank.SIX_MATCH.getWinnings() * 2) + Rank.FIVE_MATCH.getWinnings();
        assertThat(lottoResult.getTotalWinnings()).isEqualTo(expectedTotalWinnings);
    }

    @DisplayName("당첨 기록이 없는 경우, 모든 등수의 횟수는 0이고 총 상금은 0이다.")
    @Test
    void 당첨_기록이_없는_경우_초기값_검증_테스트() {
        for (Rank rank : Rank.values()) {
            assertThat(lottoResult.getWinningCount().get(rank)).isEqualTo(0);
        }

        assertThat(lottoResult.getTotalWinnings()).isEqualTo(0);
    }
}
