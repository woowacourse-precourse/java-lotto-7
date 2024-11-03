package lotto;

import domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {

    @Test
    void WinningNumber_단위_테스트() {
        String winningNumberInput = "1, 2, 3, 4, 5, 6";
        List<Integer> winningNumbers = WinningNumbers.generateWinningNumbers(winningNumberInput);

        assertEquals(6, winningNumbers.size());
        assertTrue(winningNumbers.contains(1));
        assertTrue(winningNumbers.contains(6));
    }
}
