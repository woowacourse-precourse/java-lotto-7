package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("로또 결과에서 각 당첨 등수의 당첨 횟수를 계산한다")
    @Test
    void 로또_결과에서_당첨_횟수를_계산한다() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 10, 11)), // 4등
                new Lotto(List.of(1, 2, 3, 20, 30, 40)), // 5등
                new Lotto(List.of(10, 20, 30, 40, 41, 42)) // 미당첨
        );

        // when
        LottoResult result = new LottoResult(purchasedLottos, winningLotto, bonusNumber);
        Map<Rank, Integer> rankCount = result.getRankCount();

        // then
        assertThat(rankCount.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCount.get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankCount.get(Rank.THIRD)).isEqualTo(1);
        assertThat(rankCount.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankCount.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(rankCount.get(Rank.MISS)).isEqualTo(1);
    }

    @DisplayName("로또 결과에서 수익률을 계산한다")
    @Test
    void 로또_결과에서_수익률을_계산한다() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        List<Lotto> purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)) // 2등
        );

        // when
        LottoResult result = new LottoResult(purchasedLottos, winningLotto, bonusNumber);

        // then
        double expectedYield = ((Rank.FIRST.getWinningAmount() + Rank.SECOND.getWinningAmount())
                / (double) (purchasedLottos.size() * LottoConstants.LOTTO_PRICE.getValue())) * 100;
        assertThat(result.getYield()).isEqualTo(expectedYield);
    }
}
