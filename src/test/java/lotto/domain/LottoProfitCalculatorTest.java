package lotto.domain;

import java.util.List;
import lotto.common.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoProfitCalculatorTest {
    @DisplayName("로또가 일치하는 갯수를 반환한다.")
    @Test
    void 로또가_일치하는_갯수를_반환한다() {
        // given
        IssuedRandomLotto issuedLotto = createIssuedRandomLotto();
        LottoResult lottoResult = new LottoResult(List.of(1, 2, 3, 4, 5, 6), 7);

        LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator(lottoResult, issuedLotto);

        // when
        List<LottoRank> lottoRanks = lottoProfitCalculator.calculateLottoStatistics();

        // then
        Assertions.assertThat(lottoRanks.size()).isEqualTo(2);

        Assertions.assertThat(lottoRanks.get(0).getHitCount()).isEqualTo(LottoRank.SECOND.getHitCount());
        Assertions.assertThat(lottoRanks.get(0).getPrize()).isEqualTo(LottoRank.SECOND.getPrize());
        Assertions.assertThat(lottoRanks.get(0).isBonusHit()).isEqualTo(LottoRank.SECOND.isBonusHit());

        Assertions.assertThat(lottoRanks.get(1).getHitCount()).isEqualTo(LottoRank.FOURTH.getHitCount());
        Assertions.assertThat(lottoRanks.get(1).getPrize()).isEqualTo(LottoRank.FOURTH.getPrize());
        Assertions.assertThat(lottoRanks.get(1).isBonusHit()).isEqualTo(LottoRank.FOURTH.isBonusHit());
    }

    @DisplayName("로또 수익률을 계산한다.")
    @Test
    void 수익률을_계산한다() {
        // given
        IssuedRandomLotto issuedLotto = createIssuedRandomLotto();
        LottoResult lottoResult = new LottoResult(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoProfitCalculator lottoProfitCalculator = new LottoProfitCalculator(lottoResult, issuedLotto);

        lottoProfitCalculator.calculateLottoStatistics();

        // when
        double rateOfProfit = lottoProfitCalculator.calculateRateOfProfit();

        // then
        Assertions.assertThat(rateOfProfit).isEqualTo(1001666.7);
    }

    private IssuedRandomLotto createIssuedRandomLotto() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 7));        // 2등
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 8, 9));        // 4등
        Lotto lotto3 = new Lotto(List.of(8, 9, 10, 11, 12, 13));    // 꽝
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);
        return new IssuedRandomLotto(generator, lottos, 3000);
    }

    private IssuedRandomLotto createIssuedRandomLotto2() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        Lotto four = new Lotto(List.of(1, 2, 3, 7, 8, 9));        // 4등
        Lotto boom = new Lotto(List.of(8, 9, 10, 11, 12, 13));    // 꽝
        Lotto boom2 = new Lotto(List.of(8, 9, 10, 11, 12, 13));    // 꽝
        Lotto boom3 = new Lotto(List.of(8, 9, 10, 11, 12, 13));    // 꽝
        Lotto boom4 = new Lotto(List.of(8, 9, 10, 11, 12, 13));    // 꽝
        Lotto boom5 = new Lotto(List.of(8, 9, 10, 11, 12, 13));    // 꽝
        Lotto boom6 = new Lotto(List.of(8, 9, 10, 11, 12, 13));    // 꽝
        Lotto boom7 = new Lotto(List.of(8, 9, 10, 11, 12, 13));    // 꽝
        List<Lotto> lottos = List.of(four, boom, boom2, boom3, boom4, boom5, boom6, boom7);
        return new IssuedRandomLotto(generator, lottos, 8000);
    }
}
