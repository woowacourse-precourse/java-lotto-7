package lotto;

import lotto.domain.Winning;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningTest {

    @Test
    void win_shouldReturnFirstPrize() {
        Winning result = Winning.win(6, false);
        assertEquals(Winning.FIRST, result);
    }

    @Test
    void win_shouldReturnSecondPrize() {
        Winning result = Winning.win(5, true);
        assertEquals(Winning.SECOND, result);
    }

    @Test
    void win_shouldReturnThirdPrize() {
        Winning result = Winning.win(5, false);
        assertEquals(Winning.THIRD, result);
    }

    @Test
    void win_shouldReturnFourthPrize() {
        Winning result = Winning.win(4, false);
        assertEquals(Winning.FOURTH, result);
    }

    @Test
    void win_shouldReturnFifthPrize() {
        Winning result = Winning.win(3, false);
        assertEquals(Winning.FIFTH, result);
    }

    @Test
    void win_shouldReturnFail() {
        Winning result = Winning.win(2, false);
        assertEquals(Winning.FAIL, result);
    }
}