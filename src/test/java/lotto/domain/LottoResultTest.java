package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @DisplayName("당첨 통계를 정확하게 계산한다")
    @Test
    void calculateLottoResult() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7
        );
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),  // 3등
                new Lotto(List.of(1, 2, 3, 4, 7, 8)),  // 4등
                new Lotto(List.of(1, 2, 3, 7, 8, 9))   // 5등
        );

        // when
        LottoResult result = LottoResult.of(lottos, winningLotto);
        Map<Rank, Integer> rankCount = result.getRankCount();

        // then
        assertThat(rankCount.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankCount.get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankCount.get(Rank.THIRD)).isEqualTo(1);
        assertThat(rankCount.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankCount.get(Rank.FIFTH)).isEqualTo(1);
    }

    @DisplayName("수익률을 정확하게 계산한다")
    @Test
    void calculateProfitRate() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7
        );
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  // 1등: 2,000,000,000원
                new Lotto(List.of(1, 2, 3, 4, 5, 7))   // 2등: 30,000,000원
        );

        // when
        LottoResult result = LottoResult.of(lottos, winningLotto);

        // then
        // 총 상금: 2,030,000,000원
        // 구매 금액: 2,000원
        // 수익률: (2,030,000,000 * 100) / 2,000 = 101,500,000%
        assertThat(result.calculateProfitRate()).isEqualTo(101_500_000.0);
    }

    @DisplayName("당첨이 하나도 없는 경우도 처리한다")
    @Test
    void calculateEmptyResult() {
        // given
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7
        );
        List<Lotto> lottos = List.of(
                new Lotto(List.of(40, 41, 42, 43, 44, 45))
        );

        // when
        LottoResult result = LottoResult.of(lottos, winningLotto);
        Map<Rank, Integer> rankCount = result.getRankCount();

        // then
        assertThat(rankCount.get(Rank.FIRST)).isZero();
        assertThat(rankCount.get(Rank.SECOND)).isZero();
        assertThat(rankCount.get(Rank.THIRD)).isZero();
        assertThat(rankCount.get(Rank.FOURTH)).isZero();
        assertThat(rankCount.get(Rank.FIFTH)).isZero();
        assertThat(result.calculateProfitRate()).isZero();
    }
}