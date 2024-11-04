package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constants.Rank;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private WinningNumbers winningNumbers;
    private BonusNumber bonusNumber;
    private WinningLotto winningLotto;
    private List<Lotto> lottos;
    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = new BonusNumber(List.of(7), winningNumbers);
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 6, 9)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 8, 9)), // 4등
                new Lotto(List.of(1, 2, 3, 8, 9, 10))); // 5등

        lottoResult = new LottoResult();
        lottoResult.updateRankCounts(winningLotto, lottos);
    }

    @DisplayName("로또 결과를 정확하게 계산한다.")
    @Test
    void 로또_결과를_정확하게_계산한다() {
        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.THIRD)).isEqualTo(2);
        assertThat(lottoResult.getRankCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.FIFTH)).isEqualTo(1);
    }


    @DisplayName("수익률 계산이 올바르게 수행되어야 한다.")
    @Test
    void 수익률_계산이_올바르게_수행된다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("5000");

        double expectedProfitRate =
                (double) (Rank.FIRST.getPrize() + Rank.SECOND.getPrize() + 2 * Rank.THIRD.getPrize()
                        + Rank.FOURTH.getPrize() + Rank.FIFTH.getPrize()) / purchaseAmount.getAmount() * 100;

        double actualProfitRate = lottoResult.calculateProfitRate(purchaseAmount);

        assertThat(actualProfitRate).isEqualTo(expectedProfitRate);
    }
}
