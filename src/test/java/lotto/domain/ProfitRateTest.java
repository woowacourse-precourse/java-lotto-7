package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfitRateTest {

    private PrizeResult prizeResult;
    private Money money;

    @BeforeEach
    void setUp() {
        prizeResult = new PrizeResult();
        money = new Money(10000);
    }

    @Test
    void 수익률_계산_테스트_1() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));

        prizeResult.calculatePrizes(winningLotto, new Lottos(
                List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(1, 2, 3, 4, 5, 7)))
        ));

        ProfitRate profitRate = new ProfitRate(money, prizeResult);
        double expectedProfitRate = ((2_000_000_000 + 30_000_000)) * 100.0 / money.money();

        assertEquals(expectedProfitRate, profitRate.getProfitRate());
    }

    @Test
    void 수익률_계산_테스트_2() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));

        prizeResult.calculatePrizes(winningLotto, new Lottos(
                List.of(new Lotto(List.of(11, 12, 13, 14, 15, 16)), new Lotto(List.of(11, 12, 13, 14, 15, 16)))
        ));

        ProfitRate profitRate = new ProfitRate(money, prizeResult);
        double expectedProfitRate = 0.0;

        assertEquals(expectedProfitRate, profitRate.getProfitRate());
    }
}