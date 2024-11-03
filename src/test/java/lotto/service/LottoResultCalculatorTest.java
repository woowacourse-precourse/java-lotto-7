package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCalculatorTest {
    @Test
    void 당첨결과_계산_테스트() {
        List<Lotto> userLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)), // 3등
                new Lotto(List.of(1, 2, 3, 4, 10, 11)), // 4등
                new Lotto(List.of(1, 2, 3, 20, 30, 40)) // 5등
        );

        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        int[] matchCounts = LottoResultCalculator.calculateResults(userLottos, winningNumbers, bonusNumber);

        assertThat(matchCounts[LottoRank.FIRST.ordinal()]).isEqualTo(1);
        assertThat(matchCounts[LottoRank.SECOND.ordinal()]).isEqualTo(1);
        assertThat(matchCounts[LottoRank.THIRD.ordinal()]).isEqualTo(1);
        assertThat(matchCounts[LottoRank.FOURTH.ordinal()]).isEqualTo(1);
        assertThat(matchCounts[LottoRank.FIFTH.ordinal()]).isEqualTo(1);
    }
}