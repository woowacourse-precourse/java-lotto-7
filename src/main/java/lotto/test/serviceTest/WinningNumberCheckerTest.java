package lotto.test.serviceTest;

import lotto.Lotto;
import lotto.service.WinningNumberChecker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberCheckerTest {
    @Test
    public void testSetWinningNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumberChecker winningNumberChecker = new WinningNumberChecker();
        winningNumberChecker.setWinningNumber(winningNumbers);
        assertThat(winningNumberChecker.getWinningNumbers()).containsExactlyElementsOf(winningNumbers);
    }

    @Test
    public void testSetBonusNumber() {
        WinningNumberChecker winningNumberChecker = new WinningNumberChecker();
        int bonusNumber = 7;
        winningNumberChecker.setBonusNumber(bonusNumber);
        assertThat(winningNumberChecker.doesContainBonusNumber(new Lotto(Arrays.asList(bonusNumber,1,2,3,4,5)))).isTrue();
    }

    @Test
    public void testCountMatchingNumbers() {
        WinningNumberChecker winningNumberChecker = new WinningNumberChecker();
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winningNumberChecker.setWinningNumber(winningNumbers);
        List<Integer> testNumbers = Arrays.asList(1, 2, 7, 8, 9, 10);
        int matchCount = winningNumberChecker.countMatchingNumbers(testNumbers);
        assertThat(matchCount).isEqualTo(2);
    }

    @Test
    public void testDoesContainBonusNumber() {
        WinningNumberChecker winningNumberChecker = new WinningNumberChecker();
        int bonusNumber = 7;
        winningNumberChecker.setBonusNumber(bonusNumber);
        Lotto lottoWithBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lottoWithoutBonus = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winningNumberChecker.doesContainBonusNumber(lottoWithBonus)).isTrue();
        assertThat(winningNumberChecker.doesContainBonusNumber(lottoWithoutBonus)).isFalse();
    }

    @Test
    public void run(){
        testSetWinningNumber();
        testSetBonusNumber();
        testCountMatchingNumbers();
        testDoesContainBonusNumber();
    }
}
