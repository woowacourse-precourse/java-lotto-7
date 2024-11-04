package lotto.domain;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {
    @Test
    void 로또_당첨_통계_계산_테스트() {
        // given
        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),
                new Lotto(List.of(1, 2, 3, 4, 5, 9)),
                new Lotto(List.of(1, 2, 3, 4, 5, 10))
        );
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 10;

        // when
        LottoStatistics lottoStatistics = LottoStatistics.calcStatistics(purchasedLottos, winningLotto, bonusNumber);

        Map<LottoPrize, Integer> prizeCount = lottoStatistics.getPrizeCount();
        double rateOfReturn = lottoStatistics.getRateOfReturn();

        // then
        Assertions.assertThat(prizeCount.get(LottoPrize.FIRST)).isEqualTo(1);
        Assertions.assertThat(prizeCount.get(LottoPrize.SECOND)).isEqualTo(1);
        Assertions.assertThat(prizeCount.get(LottoPrize.THIRD)).isEqualTo(3);

        Assertions.assertThat(String.format("%,.1f", rateOfReturn)).isEqualTo("40,690,000.0");
    }

    @Test
    void 로또_낱개_매칭_개수_테스트() {
        // given
        Lotto purchased = new Lotto(List.of(1, 2, 3, 11, 22, 33));
        Lotto winningLotto = new Lotto(List.of(1, 2, 33, 4, 5, 6));

        // when & then
        Assertions.assertThat(LottoStatistics.calcMatchCount(purchased, winningLotto)).isEqualTo(3);
    }
}