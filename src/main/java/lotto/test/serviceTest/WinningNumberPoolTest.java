package lotto.test.serviceTest;

import lotto.Lotto;
import lotto.service.WinningNumberChecker;
import lotto.service.WinningNumberPool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
public class WinningNumberPoolTest {
    @Test
    public void testSetWinningNumber() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(new WinningNumberPool().setWinningNumber(winningNumbers).getWinningNumbers()).containsExactlyElementsOf(winningNumbers);
    }

    @Test
    public void testSetBonusNumber() {
        assertThat(new WinningNumberPool().setBonusNumber(7).getBonusNumber()).isEqualTo(7);
    }

    @Test
    public void run(){
        testSetBonusNumber();
        testSetWinningNumber();
    }
}
