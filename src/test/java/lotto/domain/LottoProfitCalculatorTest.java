package lotto.domain;

import java.util.List;
import lotto.common.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoProfitCalculatorTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult(List.of(1, 2, 3, 4, 5, 6), 7);
    }

    @DisplayName("로또가 일치하는 갯수를 반환한다.")
    @Test
    void 로또가_일치하는_갯수_반환() {
        // given
        IssuedLotto issuedLotto = createIssuedLotto(3000, List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),       // 2등
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),       // 4등
                new Lotto(List.of(8, 9, 10, 11, 12, 13))    // 꽝
        ));

        LottoProfitCalculator calculator = new LottoProfitCalculator(lottoResult, issuedLotto);

        // when
        calculator.calculateLottoStatistics();
        List<LottoRank> lottoRanks = calculator.getLottoRanks();

        // then
        Assertions.assertThat(lottoRanks.size()).isEqualTo(2);
        validateLottoRank(lottoRanks.get(0), LottoRank.SECOND);
        validateLottoRank(lottoRanks.get(1), LottoRank.FOURTH);
    }

    @DisplayName("로또를 3개 구매해서 2등, 4등에 당첨됐을 때 수익률을 반환한다.")
    @Test
    void 로또3개구매_2등_4등_당첨됐을때의_수익률_반환() {
        // given
        IssuedLotto issuedLotto = createIssuedLotto(3000, List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),       // 2등
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),       // 4등
                new Lotto(List.of(8, 9, 10, 11, 12, 13))    // 꽝
        ));
        LottoProfitCalculator calculator = new LottoProfitCalculator(lottoResult, issuedLotto);
        calculator.calculateLottoStatistics();

        // when
        double rateOfProfit = calculator.calculateRateOfProfit();

        // then
        Assertions.assertThat(rateOfProfit).isEqualTo(1001666.7);
    }


    @DisplayName("로또를 8개 구매해서 5등에 당첨됐을 때 수익률을 반환한다.")
    @Test
    void 로또8개_구매해서_5등_한번_당첨됐을때의_수익률_반환() {
        // given
        IssuedLotto issuedLotto = createIssuedLotto(8000, List.of(
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),       // 5등
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),   // 꽝
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),   // 꽝
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),   // 꽝
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),   // 꽝
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),   // 꽝
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),   // 꽝
                new Lotto(List.of(8, 9, 10, 11, 12, 13))    // 꽝
        ));
        LottoProfitCalculator calculator = new LottoProfitCalculator(lottoResult, issuedLotto);
        calculator.calculateLottoStatistics();

        // when
        double rateOfProfit = calculator.calculateRateOfProfit();

        // then
        Assertions.assertThat(rateOfProfit).isEqualTo(62.5);
    }

    private IssuedRandomLotto createIssuedLotto(int purchaseAmount, List<Lotto> lottos) {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        return new IssuedRandomLotto(generator, lottos, purchaseAmount);
    }

    private void validateLottoRank(LottoRank actual, LottoRank expected) {
        Assertions.assertThat(actual.getHitCount()).isEqualTo(expected.getHitCount());
        Assertions.assertThat(actual.getPrize()).isEqualTo(expected.getPrize());
        Assertions.assertThat(actual.isBonusHit()).isEqualTo(expected.isBonusHit());
    }
}
