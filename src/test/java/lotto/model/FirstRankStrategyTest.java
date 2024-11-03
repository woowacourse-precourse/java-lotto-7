package lotto.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FirstRankStrategyTest {

    @DisplayName("6개 번호가 일치할 시 1등으로 당첨된다.")
    @Test
    void _6개_번호_일치하면_1등이다() {
        List<List<Integer>> lottoNumbers = List.of(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = Lotto.createLottos(lottoNumbers);
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        FirstRankStrategy firstRankStrategy = new FirstRankStrategy();
        boolean isWinning = firstRankStrategy.isWinning(winningLotto, lottos.get(0), new BonusNumber(11));
        assertTrue(isWinning);
    }

}