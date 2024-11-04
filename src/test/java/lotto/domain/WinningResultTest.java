package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {

    @Test
    @DisplayName("WinningResult 클래스 생성시 모든 순위의 결과는 0으로 초기화됩니다.")
    void initWinningResult() {
        // given
        WinningResult winningResult = new WinningResult();

        // whe, then
        assertThat(winningResult.getRankScore(LottoRank.FIRST)).isEqualTo(0);
        assertThat(winningResult.getRankScore(LottoRank.SECOND)).isEqualTo(0);
        assertThat(winningResult.getRankScore(LottoRank.THIRD)).isEqualTo(0);
        assertThat(winningResult.getRankScore(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(winningResult.getRankScore(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(winningResult.getRankScore(LottoRank.NONE)).isEqualTo(0);
    }

    @Test
    @DisplayName("총 로또 당첨 금액을 구할 수 있습니다.")
    void sumTotalReward_Success() {
        //given
        WinningResult winningResult = new WinningResult();

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        WinningLotto WinningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7);

        winningResult.matchLottosAndWinningLotto(lottos, WinningLotto);

        //when
        long totalReward = winningResult.sumTotalReward();

        //then
        assertThat(totalReward).isEqualTo(2_030_000_000);
    }

    @Test
    @DisplayName("로또 수익률을 구할 수 있습니다.")
    void calculateRateOfReturn_Success() {
        // given
        WinningResult winningResult = new WinningResult();

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 16)));
        lottos.add(new Lotto(List.of(1, 2, 3, 14, 15, 17)));

        WinningLotto WinningLotto = new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)), 7);

        winningResult.matchLottosAndWinningLotto(lottos, WinningLotto);

        // when
        double result = winningResult.calculateRateOfReturn(5000);

        // then
        assertThat(result).isEqualTo(30100.0);
    }
}
