package lotto.service;

import lotto.Lotto;
import lotto.LottoRank;
import lotto.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    private final LottoService lottoService = new LottoService();

    @Test
    void createLotto_로또번호_생성하기() {
        int purchaseCount = 5;
        List<Lotto> lottos = lottoService.createLotto(purchaseCount);

        assertEquals(purchaseCount, lottos.size());
        for (Lotto lotto : lottos) {
            assertEquals(6, lotto.getNumbers().size());
            for (int number : lotto.getNumbers()) {
                assertTrue(number >= 1 && number <= 45);
            }
        }
    }

    @Test
    void createLottoNumber_로또번호_생성() {
        List<Integer> numbers = lottoService.createLottoNumber();

        assertEquals(6, numbers.size());
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 45);
        }
        assertEquals(new HashSet<>(numbers).size(), numbers.size()); // 중복이 없어야 함
    }

    @Test
    void sortLottoNumber_로또번호_정렬() {
        List<Integer> numbers = Arrays.asList(5, 3, 1, 4, 2);
        List<Integer> sortedNumbers = lottoService.sortLottoNumber(numbers);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, sortedNumbers);
    }

    @Test
    void countMatches_일치하는_숫자_세기() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 7, 8), 6);

        int matchCount = lottoService.countMatches(lotto, winningLotto);
        assertEquals(4, matchCount);
    }

    @Test
    void hasBonus_보너스번호_확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 7), 6);

        boolean hasBonus = lottoService.hasBonus(lotto, winningLotto);
        assertTrue(hasBonus);
    }

    @Test
    void countWinningRank_당첨등수_세기() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 7), 6);
        Map<Lotto, LottoRank> rankForEach = Collections.singletonMap(lotto, LottoRank.FIFTH);

        Map<LottoRank, Integer> winningCount = lottoService.countWinningRank(rankForEach);
        assertEquals(1, winningCount.get(LottoRank.FIFTH));
    }

    @Test
    void initWinningCount_당첨횟수_초기화() {
        Map<LottoRank, Integer> winningCount = lottoService.initWinningCount(new EnumMap<>(LottoRank.class));

        for (LottoRank rank : LottoRank.values()) {
            assertEquals(0, winningCount.get(rank));
        }
    }

    @Test
    void getProfitRate_수익률_계산하기() {
        int beforeMoney = 10000;
        long afterMoney = 12000;

        String profitRate = lottoService.getProfitRate(beforeMoney, afterMoney);
        assertEquals("20.0", profitRate);
    }
}
