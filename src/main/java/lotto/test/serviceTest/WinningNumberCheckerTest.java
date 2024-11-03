package lotto.test.serviceTest;

import lotto.Lotto;
import lotto.service.WinningNumberChecker;
import lotto.service.WinningNumberPool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberCheckerTest {
    @Test
    public void testCountMatchingNumbers() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumberPool winningNumberPool = new WinningNumberPool();
        winningNumberPool.setWinningNumber(winningNumbers);
        WinningNumberChecker winningNumberChecker = new WinningNumberChecker(winningNumberPool);
        List<Integer> testNumbers = Arrays.asList(1, 2, 7, 8, 9, 10);
        assertThat(winningNumberChecker.countMatchingNumbers(testNumbers)).isEqualTo(2);
    }

    @Test
    public void testDoesContainBonusNumber() {
        WinningNumberPool winningNumberPool = new WinningNumberPool();
        winningNumberPool.setBonusNumber(7);
        WinningNumberChecker winningNumberChecker = new WinningNumberChecker(winningNumberPool);
        Lotto lottoWithBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lottoWithoutBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningNumberChecker.doesContainBonusNumber(lottoWithBonus)).isTrue();
        assertThat(winningNumberChecker.doesContainBonusNumber(lottoWithoutBonus)).isFalse();
    }

    @Test
    public void run(){
        testCountMatchingNumbers();
        testDoesContainBonusNumber();
    }
}
