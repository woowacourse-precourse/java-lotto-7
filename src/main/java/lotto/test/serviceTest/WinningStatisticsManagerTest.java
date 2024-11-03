package lotto.test.serviceTest;

import lotto.Lotto;
import lotto.service.WinningNumberChecker;
import lotto.service.WinningNumberPool;
import lotto.service.WinningStatisticsManager;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public class WinningStatisticsManagerTest {
    @Test
    public void testIncreaseThree() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumberPool winningNumberPool = new WinningNumberPool();
        winningNumberPool.setWinningNumber(List.of(1,2,3,7,8,9));
        WinningNumberChecker checker = new WinningNumberChecker(winningNumberPool);
        assertThat(new WinningStatisticsManager(checker).increaseThree(lotto).getWinningStatistics().get(WinningStatisticsManager.PrizeTier.FIFTH)).isEqualTo(1);
    }

    @Test
    public void testIncreaseFour() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumberPool winningNumberPool = new WinningNumberPool();
        winningNumberPool.setWinningNumber(List.of(1,2,3,4,8,9));
        WinningNumberChecker checker = new WinningNumberChecker(winningNumberPool);
        assertThat(new WinningStatisticsManager(checker).increaseFour(lotto).getWinningStatistics().get(WinningStatisticsManager.PrizeTier.FOURTH)).isEqualTo(1);
    }

    @Test
    public void testIncreaseFive() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumberPool winningNumberPool = new WinningNumberPool();
        winningNumberPool.setWinningNumber(List.of(1,2,3,4,5,9));
        WinningNumberChecker checker = new WinningNumberChecker(winningNumberPool);
        assertThat(new WinningStatisticsManager(checker).increaseFiveAndBonus(lotto).getWinningStatistics().get(WinningStatisticsManager.PrizeTier.THIRD)).isEqualTo(1);
    }

    @Test
    public void testIncreaseFiveAndBonus() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumberPool winningNumberPool = new WinningNumberPool();
        winningNumberPool.setWinningNumber(List.of(1,2,3,4,5,9));
        winningNumberPool.setBonusNumber(6);
        WinningNumberChecker checker = new WinningNumberChecker(winningNumberPool);
        assertThat(new WinningStatisticsManager(checker).increaseFiveAndBonus(lotto).getWinningStatistics().get(WinningStatisticsManager.PrizeTier.SECOND)).isEqualTo(1);
    }

    @Test
    public void testIncreaseSix() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumberPool winningNumberPool = new WinningNumberPool();
        winningNumberPool.setWinningNumber(List.of(1,2,3,4,5,6));
        WinningNumberChecker checker = new WinningNumberChecker(winningNumberPool);
        assertThat(new WinningStatisticsManager(checker).increaseSix(lotto).getWinningStatistics().get(WinningStatisticsManager.PrizeTier.FIRST)).isEqualTo(1);
    }

    @Test
    public void testIncreaseAll() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumberPool winningNumberPool = new WinningNumberPool();
        winningNumberPool.setWinningNumber(List.of(1,2,3,7,8,9));
        WinningNumberChecker checker = new WinningNumberChecker(winningNumberPool);
        assertThat(new WinningStatisticsManager(checker).increaseAll(lotto).getWinningStatistics().get(WinningStatisticsManager.PrizeTier.FIFTH)).isEqualTo(1);
    }

    @Test
    public void testGetEarningRate(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        WinningNumberPool winningNumberPool = new WinningNumberPool();
        winningNumberPool.setWinningNumber(List.of(1,2,3,7,8,9));
        WinningNumberChecker checker = new WinningNumberChecker(winningNumberPool);
        WinningStatisticsManager manager = new WinningStatisticsManager(checker);
        manager.increaseThree(lotto);
        BigDecimal expectedEarningRate = BigDecimal.valueOf(5000)
                .divide(BigDecimal.valueOf(1000), 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(2, RoundingMode.HALF_UP);
        assertThat(manager.getEarningRate(BigInteger.valueOf(1000))).isEqualTo(expectedEarningRate);
    }

    @Test
    public void run(){
        testIncreaseThree();
        testIncreaseFour();
        testIncreaseFive();
        testIncreaseFiveAndBonus();
        testIncreaseSix();
        testIncreaseAll();
        testIncreaseAll();
    }
}
