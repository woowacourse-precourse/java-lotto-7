package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    @DisplayName("당첨 결과 초기화 검증")
    void initializeLottoResult() {
        LottoResult result = new LottoResult(1000);

        assertThat(result.getRankCounts()).containsOnlyKeys(LottoRank.values());
        assertThat(result.getRankCounts().values()).containsOnly(0);
    }

    @Test
    @DisplayName("1등 당첨 결과 계산")
    void 일등_당첨_결과_테스트() {
        LottoResult result = new LottoResult(1000);
        Lotto userLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));

        result.addWinningResult(userLotto, winningLotto, 7);

        assertThat(result.getRankCounts().get(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등 당첨 결과 계산")
    void 이등_당첨_결과_테스트() {
        LottoResult result = new LottoResult(1000);
        Lotto userLotto = new Lotto(List.of(1,2,3,4,5,7));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));

        result.addWinningResult(userLotto, winningLotto, 7);

        assertThat(result.getRankCounts().get(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("3등 당첨 결과 계산")
    void 삼등_당첨_결과_테스트() {
        LottoResult result = new LottoResult(1000);
        Lotto userLotto = new Lotto(List.of(1,2,3,4,5,8));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));

        result.addWinningResult(userLotto, winningLotto, 7);

        assertThat(result.getRankCounts().get(LottoRank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률 계산")
    void calculateProfitRate() {
        LottoResult result = new LottoResult(1000);
        Lotto userLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(List.of(1,2,3,4,5,6));

        result.addWinningResult(userLotto, winningLotto, 7);

        assertThat(result.calculateProfitRate()).isEqualTo(200000000.0);
    }
}