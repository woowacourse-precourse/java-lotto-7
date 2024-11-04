package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
    @Test
    @DisplayName("당첨 결과와 수익률이 올바르게 계산된다.")
    void calculateStatistics() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoStatistics statistics = new LottoStatistics(lottos, winningNumbers);

        assertThat(statistics.getResult().get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(statistics.getResult().get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(statistics.getResult().get(LottoRank.MISS)).isEqualTo(1);
        assertThat(statistics.getProfitRate()).isEqualTo((2_000_000_000 + 30_000_000) / (3_000.0) * 100);
    }

    @Test
    @DisplayName("당첨 결과가 없는 경우 수익률이 0이다.")
    void calculateProfitRateWithNoWins() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 22, 25, 39, 44)),
                new Lotto(List.of(7, 11, 16, 35, 36, 40))
        );
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoStatistics statistics = new LottoStatistics(lottos, winningNumbers);

        assertThat(statistics.getResult().get(LottoRank.MISS)).isEqualTo(2);
        assertThat(statistics.getProfitRate()).isEqualTo(0);
    }
}