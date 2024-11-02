package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

class LottoMatchingCounterTest {
    private LottoMatchingCounter lottoMatchingCounter;
    private final String WINNING_COUNT = "winningCount";
    private final String BONUS_COUNT = "bonusCount";
    private List<Integer> winningNumbers;
    private int bonusNumber;

    @Test
    void 당첨번호와_구매내역이_0개_일치한지_확인한다() {
        winningNumbers = new ArrayList<>(List.of(11, 12, 13, 14, 15, 16));
        bonusNumber = 7;
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        lottoMatchingCounter = new LottoMatchingCounter(winningNumbers, bonusNumber);

        HashMap<String, Integer> count = lottoMatchingCounter.countMatchingNumbers(purchasedLotto);

        assertEquals(0, count.get(WINNING_COUNT));
        assertEquals(0, count.get(BONUS_COUNT));
    }

    @Test
    void 당첨번호와_구매내역이_3개_일치한지_확인한다() {
        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 12, 45, 13));
        bonusNumber = 7;
        lottoMatchingCounter = new LottoMatchingCounter(winningNumbers, bonusNumber);

        HashMap<String, Integer> count = lottoMatchingCounter.countMatchingNumbers(purchasedLotto);

        assertEquals(3, count.get(WINNING_COUNT));
        assertEquals(0, count.get(BONUS_COUNT));
    }

    @Test
    void 당첨번호와_구매내역이_4개_일치한지_확인한다() {
        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 15, 16));
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        lottoMatchingCounter = new LottoMatchingCounter(winningNumbers, bonusNumber);

        HashMap<String, Integer> count = lottoMatchingCounter.countMatchingNumbers(purchasedLotto);

        assertEquals(4, count.get(WINNING_COUNT));
        assertEquals(0, count.get(BONUS_COUNT));
    }

    @Test
    void 당첨번호가_5개_일치할때_보너스번호도_일치하는지_확인한다() {
        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        bonusNumber = 7;
        lottoMatchingCounter = new LottoMatchingCounter(winningNumbers, bonusNumber);

        HashMap<String, Integer> count = lottoMatchingCounter.countMatchingNumbers(purchasedLotto);

        assertEquals(5, count.get(WINNING_COUNT));
        assertEquals(1, count.get(BONUS_COUNT));
    }

    @Test
    void 당첨번호와_구매내역이_6개_일치한지_확인한다() {
        winningNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto purchasedLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        lottoMatchingCounter = new LottoMatchingCounter(winningNumbers, bonusNumber);

        HashMap<String, Integer> count = lottoMatchingCounter.countMatchingNumbers(purchasedLotto);

        assertEquals(6, count.get(WINNING_COUNT));
        assertEquals(0, count.get(BONUS_COUNT));
    }
}