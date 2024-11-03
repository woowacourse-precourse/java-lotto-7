package model;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.LottoResultStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultStatisticsTest {
    private LottoResultStatistics statistics;

    @BeforeEach
    void setUp() {
        statistics = new LottoResultStatistics();
    }

    @Test
    void 통계_분석_테스트() {
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10)),
                new Lotto(List.of(1, 2, 3, 4, 20, 21))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        statistics.analyze(purchasedLottos, winningNumbers, bonusNumber);

        assertThat(statistics.getResultCount(LottoResult.SIX_NUMBER_MATCH)).isEqualTo(1);
        assertThat(statistics.getResultCount(LottoResult.FIVE_NUMBER_AND_BONUS_NUMBER_MATCH)).isEqualTo(1);
        assertThat(statistics.getResultCount(LottoResult.FIVE_NUMBER_MATCH)).isEqualTo(1);
        assertThat(statistics.getResultCount(LottoResult.FOUR_NUMBER_MATCH)).isEqualTo(1);
        assertThat(statistics.getResultCount(LottoResult.THREE_NUMBER_MATCH)).isEqualTo(0);
    }

    @Test
    void 총_수익_계산_테스트() {
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10))
        );
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        statistics.calculateTotalEarnings(purchasedLottos, winningNumbers, bonusNumber);

        int expectedEarnings = LottoResult.SIX_NUMBER_MATCH.lottoPrize() +
                LottoResult.FIVE_NUMBER_AND_BONUS_NUMBER_MATCH.lottoPrize() +
                LottoResult.FIVE_NUMBER_MATCH.lottoPrize();

        assertThat(statistics.totalEarnings).isEqualTo(expectedEarnings);
    }

    @Test
    void 수익률_계산_테스트() {
        statistics.setTotalExpense(5000);
        statistics.totalEarnings = 20000;

        double expectedProfitRate = 400.0;
        assertThat(statistics.calculateProfitRate()).isEqualTo(expectedProfitRate);
    }
}
