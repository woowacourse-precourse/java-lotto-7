package lotto.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FifthRankStrategyTest {

    @DisplayName("3개 번호가 일치할 경우 5등이다.")
    @Test
    void _3개_번호_일치할_경우_5등이다() {
        List<List<Integer>> lottoNumbers = List.of(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = Lotto.createLottos(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 7, 8, 9));
        FifthRankStrategy fifthRankStrategy = new FifthRankStrategy();
        boolean isWinning = fifthRankStrategy.isWinning(winningLotto, lottos.get(0), new BonusNumber(11));
        assertTrue(isWinning);
    }


}