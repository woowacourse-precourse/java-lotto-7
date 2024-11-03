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
    void shouldReturnCorrectMatchCountForLottos() {
        IssuedRandomLotto issuedLotto = createIssuedLotto(3000, List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),       // 2등
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),       // 4등
                new Lotto(List.of(8, 9, 10, 11, 12, 13))    // 꽝
        ));

        LottoProfitCalculator calculator = new LottoProfitCalculator(lottoResult, issuedLotto);
        List<LottoRank> lottoRanks = calculator.calculateLottoStatistics();

        Assertions.assertThat(lottoRanks.size()).isEqualTo(2);
        validateLottoRank(lottoRanks.get(0), LottoRank.SECOND);
        validateLottoRank(lottoRanks.get(1), LottoRank.FOURTH);
    }

    @DisplayName("로또 수익률을 계산한다.")
    @Test
    void shouldCalculateProfitRate() {
        IssuedRandomLotto issuedLotto = createIssuedLotto(3000, List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),       // 2등
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),       // 4등
                new Lotto(List.of(8, 9, 10, 11, 12, 13))    // 꽝
        ));

        IssuedRandomLotto issuedLotto2 = createIssuedLotto(8000, List.of(
                new Lotto(List.of(1, 2, 3, 7, 8, 9)),       // 4등
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),   // 꽝
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),   // 꽝
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),   // 꽝
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),   // 꽝
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),   // 꽝
                new Lotto(List.of(8, 9, 10, 11, 12, 13)),   // 꽝
                new Lotto(List.of(8, 9, 10, 11, 12, 13))    // 꽝
        ));

        LottoProfitCalculator calculator = new LottoProfitCalculator(lottoResult, issuedLotto);
        LottoProfitCalculator calculator2 = new LottoProfitCalculator(lottoResult, issuedLotto2);

        calculator.calculateLottoStatistics();
        calculator2.calculateLottoStatistics();

        double rateOfProfit = calculator.calculateRateOfProfit();
        double rateOfProfit2 = calculator2.calculateRateOfProfit();

        Assertions.assertThat(rateOfProfit).isEqualTo(1001666.7);
        Assertions.assertThat(rateOfProfit2).isEqualTo(62.5);
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
