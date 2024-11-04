package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningNumberTest {

    @Test
    public void 당첨번호_및_보너스번호_생성_테스트() {
        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(winningNumbers, 7);

        assertEquals(winningNumbers, winningNumber.getNumbers());
        assertEquals(7, winningNumber.getBonusNumber());
    }
}
