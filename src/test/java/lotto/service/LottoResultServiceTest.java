package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.MatchingCountResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultServiceTest {
    private LottoResultService lottoResultService;
    private LottoSeller lottoSeller;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        List<Lotto> purchasedLotto = new ArrayList<>(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), new Lotto(List.of(1, 2, 3, 4, 5, 6))));
        lottoResultService = new LottoResultService(purchasedLotto, winningNumbers, bonusNumber);
    }

    @Test
    void 당첨상태의_개수를_판별한다() {
        List<MatchingCountResult> matchingCountResults = lottoResultService.getWinningCount();

        assertEquals(2, matchingCountResults.size());
        assertEquals(5, matchingCountResults.get(0).winningCondition().getMatchCount());
        assertTrue(matchingCountResults.get(0).winningCondition().isBonusMatch());

        assertEquals(5, matchingCountResults.get(0).winningCondition().getMatchCount());
        assertFalse(matchingCountResults.get(1).winningCondition().isBonusMatch());
    }
}