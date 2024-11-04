package lotto.checker;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.config.enumerate.WinningInfo;
import lotto.data.Lotto;
import lotto.data.WinningLotto;
import lotto.data.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningCheckerTest {

    private WinningLotto winningLotto;
    private WinningChecker winningChecker;

    @BeforeEach
    public void setUp() {
        winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        winningChecker = new WinningChecker(winningLotto);
    }

    @Test
    public void 로또에_대한_일치_결과를_테스트한다() {

        //given
        List<Lotto> lottoes = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),  // 6개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),  // 5개 일치 + bonus
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),  // 5개 일치
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)), // 3개 일치
                new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13)) // 0개 일치
        );

        long purchaseAmount = 5000L;

        //then
        WinningResult result = winningChecker.getWinningResult(purchaseAmount, lottoes);
        assertEquals(1, result.getWinningCount().get(WinningInfo.SIX)); // 6개 일치
        assertEquals(1, result.getWinningCount().get(WinningInfo.BONUS)); // 5개 일치 + bonus
        assertEquals(1, result.getWinningCount().get(WinningInfo.FIVE)); // 5개 일치
        assertEquals(1, result.getWinningCount().get(WinningInfo.THREE)); // 3개 일치
        assertEquals(1, result.getWinningCount().get(WinningInfo.ZERO)); // 0개 일치
    }

    @Test
    public void 수익률에_대한_결과를_테스트한다() {

        //given
        List<Lotto> lottoes = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 6개 일치
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 5개 일치 + bonus
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))  // 5개 일치
        );

        long purchaseAmount = 3000L;
        WinningResult result = winningChecker.getWinningResult(purchaseAmount, lottoes);

        // then
        double expectedProfitRate = ((WinningInfo.SIX.getPrize() + WinningInfo.BONUS.getPrize() + WinningInfo.FIVE.getPrize()) / (double) purchaseAmount) * 100;
        assertEquals(expectedProfitRate, result.getProfitRate(), 0.01);
    }

}