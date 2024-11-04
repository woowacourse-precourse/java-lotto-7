package lotto.model;

import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        lottoStatistics = new LottoStatistics();
    }

    @Test
    @DisplayName("로또 당첨 통계를 올바르게 계산한다.")
    void calculateStatistics() {
        Lotto thirdPlaceLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7)); // 5개 일치, 보너스 번호 일치 O
        Lotto fifthPlaceLotto1 = new Lotto(List.of(1, 2, 3, 8, 9, 10)); // 3개 일치
        Lotto fifthPlaceLotto2 = new Lotto(List.of(1, 2, 3, 10, 11, 12)); // 3개 일치
        List<Lotto> lottos = List.of(thirdPlaceLotto, fifthPlaceLotto1, fifthPlaceLotto2);

        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        lottoStatistics.calculateStatistics(lottos, winningNumbers);

        Map<Rank, Integer> resultMap = lottoStatistics.getResultMap();
        assertThat(resultMap.get(Rank.SECOND)).isEqualTo(1);
        assertThat(resultMap.get(Rank.FIFTH)).isEqualTo(2);
    }

    @Test
    @DisplayName("구입 금액과 당첨 결과에 따른 수익률을 올바르게 계산한다.")
    void calculateProfit() {
        Lotto firstPlaceLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 1등 당첨
        List<Lotto> lottos = List.of(firstPlaceLotto);

        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);

        lottoStatistics.calculateStatistics(lottos, winningNumbers);

        int purchaseAmount = 1000;
        double profit = lottoStatistics.calculateProfit(purchaseAmount);

        assertThat(profit).isEqualTo(200_000_000.0);
    }
}
