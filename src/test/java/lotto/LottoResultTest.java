package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    void 당첨_결과_초기화_검증() {
        LottoResult result = new LottoResult(1000);

        assertThat(result.getRankCounts()).containsOnlyKeys(LottoRank.values());
        assertThat(result.getRankCounts().values()).containsOnly(0);
    }

    @Test
    void 일등_당첨_결과_테스트() {
        LottoResult result = new LottoResult(1000);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        result.addWinningResult(userLotto, winningLotto);

        assertThat(result.getRankCounts().get(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    void 이등_당첨_결과_테스트() {
        LottoResult result = new LottoResult(1000);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        result.addWinningResult(userLotto, winningLotto);

        assertThat(result.getRankCounts().get(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    void 삼등_당첨_결과_테스트() {
        LottoResult result = new LottoResult(1000);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        result.addWinningResult(userLotto, winningLotto);

        assertThat(result.getRankCounts().get(LottoRank.THIRD)).isEqualTo(1);
    }

    @Test
    void 수익률_계산_테스트() {
        LottoResult result = new LottoResult(1000);
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        result.addWinningResult(userLotto, winningLotto);

        assertThat(result.calculateProfitRate()).isEqualTo(200000000.0);
    }
}