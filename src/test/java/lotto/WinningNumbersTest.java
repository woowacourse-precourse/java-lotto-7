package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @Test
    void 당첨_계산_테스트() {
        WinningNumbers wn = new WinningNumbers(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(List.of(3,4,5,6,7,8));
        lotto.setWinningNumberMatch(wn.matchNumberCount(lotto));

        assertEquals(4, lotto.getWinningNumberMatch());
        assertTrue(wn.isBonusNumberMatch(lotto));

    }


}
