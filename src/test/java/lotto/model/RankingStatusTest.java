package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RankingStatusTest {
    private RankingStatus rankingStatus;

    @DisplayName("로또를 통해 번 전체금액 구하기")
    @Test
    void 로또를_통해_번_전체금액_구하기() {
        // given
        rankingStatus = new RankingStatus();
        rankingStatus.updateRankStatus(Ranking.FIRST);
        rankingStatus.updateRankStatus(Ranking.SECOND);

        long expectedTotalPrize = 2_000_000_000 + 30_000_000;

        // when
        long actualTotalPrize = rankingStatus.getTotalPrize();

        // then
        assertThat(expectedTotalPrize).isEqualTo(actualTotalPrize);
    }

}