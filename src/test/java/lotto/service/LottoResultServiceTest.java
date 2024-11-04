package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.MatchingCountResult;
import org.junit.jupiter.api.Test;

class LottoResultServiceTest {
    private LottoResultService lottoResultService;

    /*
    winningCount: 1,2,3,4,5,6
    - 1,2,3,4,5,7 (5) + bonus
    - 1,2,3,4,5,6 (6)
     */
    @Test
    void 사용자의_로또에서_당첨된_숫자와_보너스를_센다() {
        //given
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> purchasedLotto = new ArrayList<>(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        lottoResultService = new LottoResultService(purchasedLotto, winningNumbers, bonusNumber);
        //when
        List<MatchingCountResult> matchingCountResults = lottoResultService.getWinningCount();
        //then
        assertThat(matchingCountResults.get(0).getConditionCount()).isEqualTo(0);
        assertThat(matchingCountResults.get(1).getConditionCount()).isEqualTo(0);
        assertThat(matchingCountResults.get(2).getConditionCount()).isEqualTo(0);
        assertThat(matchingCountResults.get(3).getConditionCount()).isEqualTo(1); //5개+보너스:하나
        assertThat(matchingCountResults.get(4).getConditionCount()).isEqualTo(1); //6개:하나
    }

    @Test
    void 사용자의_로또에서_당첨된_숫자를_센다() {
        //given
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> purchasedLotto = new ArrayList<>(
                List.of(new Lotto(List.of(1, 2, 3, 9, 10, 11)), new Lotto(List.of(1, 2, 3, 22, 23, 24))));
        lottoResultService = new LottoResultService(purchasedLotto, winningNumbers, bonusNumber);
        //when
        List<MatchingCountResult> matchingCountResults = lottoResultService.getWinningCount();
        //then
        assertThat(matchingCountResults.get(0).getConditionCount()).isEqualTo(2);
        assertThat(matchingCountResults.get(1).getConditionCount()).isEqualTo(0);
        assertThat(matchingCountResults.get(2).getConditionCount()).isEqualTo(0);
        assertThat(matchingCountResults.get(3).getConditionCount()).isEqualTo(0);
        assertThat(matchingCountResults.get(4).getConditionCount()).isEqualTo(0);
    }

}