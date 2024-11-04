package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;

    @BeforeEach
    void setUp() {
        lottos = Lottos.from(List.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),  // 1등 당첨
                Lotto.from(List.of(1, 2, 3, 4, 5, 7)),  // 2등 당첨
                Lotto.from(List.of(1, 2, 3, 4, 5, 8)),  // 3등 당첨
                Lotto.from(List.of(1, 2, 3, 4, 10, 11)), // 4등 당첨
                Lotto.from(List.of(1, 2, 3, 10, 11, 12)) // 5등 당첨
        ));
        winningNumbers = WinningNumbers.from("1,2,3,4,5,6");
        bonusNumber = BonusNumber.from("7", List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 순위별_카운트_정상_계산() {
        // given
        int totalPurchaseAmount = 5000;

        // when
        LottoStatistics statistics = new LottoStatistics(lottos, winningNumbers, bonusNumber, totalPurchaseAmount);

        // then
        Map<Rank, Integer> rankCounts = statistics.getRankCounts();
        assertThat(rankCounts.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.THIRD)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankCounts.get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    void 수익률을_통해_총_상금_간접_검증() {
        // given
        int totalPurchaseAmount = 5000;

        // when
        LottoStatistics statistics = new LottoStatistics(lottos, winningNumbers, bonusNumber, totalPurchaseAmount);

        // then
        double expectedProfitRate = (double) (Rank.FIRST.getPrize() + Rank.SECOND.getPrize() +
                Rank.THIRD.getPrize() + Rank.FOURTH.getPrize() + Rank.FIFTH.getPrize()) / totalPurchaseAmount * 100;
        assertThat(statistics.calculateProfitRate()).isEqualTo(expectedProfitRate);
    }

    @Test
    void 구매금액이_0일_때_수익률_0_계산() {
        // given
        int totalPurchaseAmount = 0;

        // when
        LottoStatistics statistics = new LottoStatistics(lottos, winningNumbers, bonusNumber, totalPurchaseAmount);

        // then
        assertThat(statistics.calculateProfitRate()).isEqualTo(0);
    }
}
