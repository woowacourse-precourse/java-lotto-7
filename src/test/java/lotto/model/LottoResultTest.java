package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @Test
    void 각_등수별_당첨_횟수_계산() {
        WinningLotto winningNumbers = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등 (5개 + 보너스)
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 3등 (5개)
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)), // 4등 (4개)
                new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13)), // 5등 (3개)
                new Lotto(Arrays.asList(14, 15, 16, 17, 18, 19)) // 미당첨
        );

        LottoResult lottoResult = new LottoResult(winningNumbers, purchasedLottos);
        Map<Rank, Integer> resultCount = lottoResult.getResultCountMap();

        assertThat(resultCount.get(Rank.FIRST)).isEqualTo(1);   // 1등 1회
        assertThat(resultCount.get(Rank.SECOND)).isEqualTo(1);  // 2등 1회
        assertThat(resultCount.get(Rank.THIRD)).isEqualTo(1);   // 3등 1회
        assertThat(resultCount.get(Rank.FOURTH)).isEqualTo(1);  // 4등 1회
        assertThat(resultCount.get(Rank.FIFTH)).isEqualTo(1);   // 5등 1회
    }

    @Test
    void 일치_하는_번호가_없는_경우() {
        WinningLotto winningNumbers = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(14, 15, 16, 17, 18, 19)), // 미당첨
                new Lotto(Arrays.asList(20, 21, 22, 23, 24, 25))  // 미당첨
        );

        LottoResult lottoResult = new LottoResult(winningNumbers, purchasedLottos);
        Map<Rank, Integer> resultCount = lottoResult.getResultCountMap();

        assertThat(resultCount.get(Rank.FIRST)).isEqualTo(0);
        assertThat(resultCount.get(Rank.SECOND)).isEqualTo(0);
        assertThat(resultCount.get(Rank.THIRD)).isEqualTo(0);
        assertThat(resultCount.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(resultCount.get(Rank.FIFTH)).isEqualTo(0);
    }
}