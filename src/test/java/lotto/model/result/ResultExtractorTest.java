package lotto.model.result;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoMachine;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.WinningLotto;
import lotto.model.lottogenerator.FixedLottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultExtractorTest {
    private final LottoMachine lottoMachine = new LottoMachine(new FixedLottoNumberGenerator());
    private ResultExtractor resultExtractor;

    @BeforeEach
    void setUp() {
        final Lotto winningNumber = new Lotto(List.of(3, 16, 20, 23, 27, 22));
        final WinningLotto winningLotto = new WinningLotto(winningNumber, new BonusNumber("7"));
        final Lottos lottos = lottoMachine.execute(6);

        resultExtractor = new ResultExtractor(winningLotto, lottos);
    }

    @Test
    @DisplayName("랭크 추출 테스트")
    void extractLottoResult() {
        Map<Rank, Integer> result = resultExtractor.extract();

        Map<Rank, Integer> expected = new HashMap<>();
        expected.put(Rank.FIRST, 0);
        expected.put(Rank.SECOND, 1);
        expected.put(Rank.THIRD, 1);
        expected.put(Rank.FOURTH, 0);
        expected.put(Rank.FIFTH, 2);
        expected.put(Rank.MISS, 2);

        assertThat(result).containsExactlyInAnyOrderEntriesOf(expected);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateProfitRate() {
        // given
        resultExtractor.extract();
        int originalMoney = 6000;

        // when
        double profit = resultExtractor.calculateProfitRate(originalMoney);

        // then
        double expected = ((double) 31510000 / originalMoney) * 100;
        assertThat(profit).isEqualTo(expected);
    }
}
