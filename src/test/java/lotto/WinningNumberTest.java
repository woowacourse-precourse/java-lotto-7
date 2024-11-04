package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WinningNumberTest {

    @Test
    public void testGetWinningNumber() {
        WinningNumber winningNumber = new WinningNumber();
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        winningNumber.setWinningNumber(expected);
        assertEquals(expected, winningNumber.getWinningNumber());
    }

    @Test
    public void testGetBonusNum() {
        WinningNumber winningNumber = new WinningNumber();
        int expected = 7;
        winningNumber.setBonusNum(expected);
        assertEquals(expected, winningNumber.getBonusNum());
    }

    @Test
    public void testChangeType() {
        WinningNumber winningNumber = new WinningNumber();
        String[] inputNum = {"1", "2", "3", "4", "5", "6"};
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        assertEquals(expected, winningNumber.changeType(inputNum));
    }
    
}
    