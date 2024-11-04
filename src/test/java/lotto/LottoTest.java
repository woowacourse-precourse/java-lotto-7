package lotto;

import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoResultChecker;
import lotto.model.LottoStatistics;
import lotto.model.WinningRank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {

    private LottoGenerator generator;
    private LottoResultChecker checker;
    private LottoStatistics statistics;

    @BeforeEach
    void setUp() {
        generator = new LottoGenerator();
        checker = new LottoResultChecker();
        statistics = new LottoStatistics();
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("로또 번호가 비어 있을 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_비어_있을_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 비어 있을 수 없습니다.");
    }

    @DisplayName("로또 번호가 1~45 범위를 벗어날 경우 예외가 발생한다.")
    @Test
    void 로또_번호가_1에서_45_범위를_벗어날_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("구입 금액에 따른 로또 발행 개수 알맞은지 확인")
    @Test
    void 구입_금액에_따라_로또_발행_개수가_알맞은지_확인() {
        int purchaseAmount = 5000;
        List<Lotto> lottos = generator.generateLottos(purchaseAmount);

        Assertions.assertEquals(5, lottos.size());
        lottos.forEach(lotto -> Assertions.assertEquals(6, lotto.getNumbers().size()));
    }

    @DisplayName("로또 티켓과 당첨 번호 비교 후 당첨 결과 알맞은지 확인")
    @Test
    void 로또_티켓과_당첨_번호_비교_후_당첨_결과가_알맞은지_확인() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Lotto firstPrizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondPrizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto fifthPrizeLotto = new Lotto(List.of(1, 2, 3, 10, 11, 12));

        List<Lotto> lottos = List.of(firstPrizeLotto, secondPrizeLotto, fifthPrizeLotto);

        Map<WinningRank, Integer> results = checker.checkResults(lottos, winningNumbers, bonusNumber);

        assertThat(results.get(WinningRank.FIRST)).isEqualTo(1);
        assertThat(results.get(WinningRank.SECOND)).isEqualTo(1);
        assertThat(results.getOrDefault(WinningRank.THIRD, 0)).isEqualTo(0);
        assertThat(results.get(WinningRank.FIFTH)).isEqualTo(1);
        assertThat(results.getOrDefault(WinningRank.FOURTH, 0)).isEqualTo(0);
    }

    @DisplayName("당첨 결과와 구입 금액을 바탕으로 수익률 알맞은지 확인")
    @Test
    void 당첨_결과와_구입_금액을_바탕으로_수익률이_알맞은지_확인() {
        Map<WinningRank, Integer> results = Map.of(
                WinningRank.FIRST, 1,
                WinningRank.THIRD, 2,
                WinningRank.FIFTH, 3
        );
        int purchaseAmount = 10000;
        double yield = statistics.calculateYield(results, purchaseAmount);

        int expectedTotalPrize = 2_000_000_000 + (1_500_000 * 2) + (5_000 * 3);
        double expectedYield = (double) expectedTotalPrize / purchaseAmount * 100;

        assertThat(yield).isEqualTo(expectedYield);
    }
}
