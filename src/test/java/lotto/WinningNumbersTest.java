package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {
    @Test
    void 당첨_계산_테스트() {
        WinningNumbers wn = new WinningNumbers(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(List.of(3,4,5,6,7,8));
        assertEquals(WinningResult.FOURTH, lotto.checkWinningResult(wn.matchNumberCount(lotto), wn.isBonusNumberMatch(lotto)));
    }

    @Test
    void 당첨_2등_테스트() {
        WinningNumbers wn = new WinningNumbers(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(List.of(2,3,4,5,6,7));
        assertEquals(WinningResult.SECOND, lotto.checkWinningResult(wn.matchNumberCount(lotto), wn.isBonusNumberMatch(lotto)));
    }

    @Test
    void 당첨_3등_테스트() {
        WinningNumbers wn = new WinningNumbers(List.of(1,2,3,4,5,6), 7);
        Lotto lotto = new Lotto(List.of(2,3,4,5,6,8));

        assertEquals(WinningResult.THIRD, lotto.checkWinningResult(wn.matchNumberCount(lotto), wn.isBonusNumberMatch(lotto)));
    }


}
