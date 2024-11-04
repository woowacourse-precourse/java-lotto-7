package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrizeResultTest {

    private PrizeResult prizeResult;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        prizeResult = new PrizeResult();
        winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));
    }

    @Test
    void 당첨_결과_계산_테스트() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),       // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),       // 2등
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),    // 5등
                new Lotto(List.of(10, 11, 12, 13, 14, 15))  // 당첨X
        ));

        prizeResult.calculatePrizes(winningLotto, lottos);

        assertEquals(1, prizeResult.getPrizeCount(Prize.SIX_MATCH));
        assertEquals(1, prizeResult.getPrizeCount(Prize.FIVE_MATCH_WITH_BONUS_BALL));
        assertEquals(0, prizeResult.getPrizeCount(Prize.FIVE_MATCH_WITHOUT_BONUS_BALL));
        assertEquals(0, prizeResult.getPrizeCount(Prize.FOUR_MATCH));
        assertEquals(1, prizeResult.getPrizeCount(Prize.THREE_MATCH));
    }

    @Test
    void 총_수익_계산_테스트() {
        Lottos lottos = new Lottos(List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),       // 1등
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),    // 5등
                new Lotto(List.of(1, 2, 3, 10, 11, 12)),    // 5등
                new Lotto(List.of(10, 11, 12, 13, 14, 15))  // 당첨X
        ));

        prizeResult.calculatePrizes(winningLotto, lottos);

        int expectedProfit = 2_000_000_000 + 5_000 * 2;
        assertEquals(expectedProfit, prizeResult.getSumOfProfit());
    }
}