package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.LottoResult;
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
        List<LottoResult> lottoResults = lottoResultService.getWinningCount();

        assertEquals(2, lottoResults.size());
        assertEquals(5, lottoResults.get(0).winningCondition().getMatchCount());
        assertTrue(lottoResults.get(0).winningCondition().isBonusMatch());

        assertEquals(5, lottoResults.get(0).winningCondition().getMatchCount());
        assertFalse(lottoResults.get(1).winningCondition().isBonusMatch());


    }
}