package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoCheckerTest {

    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<Lotto> purchasedLottos;

    @BeforeEach
    void setUp() {
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
        purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 2등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)), // 3등
                new Lotto(Arrays.asList(1, 2, 3, 4, 10, 11)), // 4등
                new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12)) // 5등
        );
    }

    @Test
    void testCheckResults() {
        Map<LottoRank, Integer> resultMap = LottoChecker.checkResults(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(1, resultMap.get(LottoRank.FIRST));
        assertEquals(1, resultMap.get(LottoRank.SECOND));
        assertEquals(1, resultMap.get(LottoRank.THIRD));
        assertEquals(1, resultMap.get(LottoRank.FOURTH));
        assertEquals(1, resultMap.get(LottoRank.FIFTH));
        assertEquals(0, resultMap.get(LottoRank.MISS));
    }

    @Test
    void testGenerateResultSummary() {
        Map<LottoRank, Integer> resultMap = LottoChecker.checkResults(purchasedLottos, winningNumbers, bonusNumber);

        String resultSummary = LottoChecker.generateResultSummary(resultMap);

        String expectedSummary = String.format(
                "3개 일치 (%,d원) - 1개\n" +
                        "4개 일치 (%,d원) - 1개\n" +
                        "5개 일치 (%,d원) - 1개\n" +
                        "5개 일치, 보너스 볼 일치 (%,d원) - 1개\n" +
                        "6개 일치 (%,d원) - 1개\n",
                LottoRank.FIFTH.getPrize(),
                LottoRank.FOURTH.getPrize(),
                LottoRank.THIRD.getPrize(),
                LottoRank.SECOND.getPrize(),
                LottoRank.FIRST.getPrize()
        );

        assertEquals(expectedSummary, resultSummary);
    }

}
