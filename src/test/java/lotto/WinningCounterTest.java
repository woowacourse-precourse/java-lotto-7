package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WinningCounterTest {

    @Test
    void calculateProfitAmount_테스트() {
        WinningCounter winningCounter = new WinningCounter();
        winningCounter.addWinning(Winning.Match6);

        assertEquals(2000000000, winningCounter.calculateProfitAmount());
    }
}