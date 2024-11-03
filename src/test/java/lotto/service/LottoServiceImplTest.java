package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.RankCount;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceImplTest {
    private final LottoServiceImpl lottoService = new LottoServiceImpl();

    @Test
    void 구입_금액에_해당하는_만큼_로또_발행() {
        int price = 10000;
        int expectedResult = 10;

        int actualCount = lottoService.calculateLottoCount(price);

        assertEquals(expectedResult, actualCount);
    }

    @Test
    void 로또번호_범위_사이의_중복되지_않은_정수_6개_반환() {
        List<Integer> numbers = lottoService.pickLottoNumbers();
        int expectedCount = 6;
        int expectedRangeStart = 1;
        int expectedRangeEnd = 45;

        assertTrue(numbers.stream().allMatch(num -> num >= expectedRangeStart && num <= expectedRangeEnd));
        assertEquals(expectedCount, numbers.size());
        assertEquals(expectedCount, numbers.stream().distinct().count());
    }

    @Test
    void 당첨_통계를_올바르게_계산한다() {
        Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Integer bonusNumber = 7;

        Lottos lottos = createLottos();

        List<RankCount> rankCounts = lottoService.calculateWinningStatistics(lottos, winningNumbers, bonusNumber);

        int expectedResult = 1;
        assertEquals(expectedResult, rankCounts.get(4).getCount());
        assertEquals(expectedResult, rankCounts.get(3).getCount());
        assertEquals(expectedResult, rankCounts.get(2).getCount());
        assertEquals(expectedResult, rankCounts.get(1).getCount());
        assertEquals(expectedResult, rankCounts.get(0).getCount());
    }

    private Lottos createLottos() {
        List<Lotto> createdLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 20)),
                new Lotto(Arrays.asList(1, 2, 3, 10, 20, 30)),
                new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))
        );

        Lottos lottos = new Lottos();
        for (Lotto lotto : createdLottos) {
            lottos.addLotto(lotto);
        }
        return lottos;
    }
}