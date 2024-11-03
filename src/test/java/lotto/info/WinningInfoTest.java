package lotto.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class WinningInfoTest {

    @Test
    public void 맞힌_개수와_보너스_수에_따른_순위_판단() {
        assertEquals(WinningInfo.FIRST, WinningInfo.getRankByMatchCountAndBonus(6, false));

        assertEquals(WinningInfo.SECOND, WinningInfo.getRankByMatchCountAndBonus(5, true));

        assertEquals(WinningInfo.THIRD, WinningInfo.getRankByMatchCountAndBonus(5, false));

        assertEquals(WinningInfo.FOURTH, WinningInfo.getRankByMatchCountAndBonus(4, false));

        assertEquals(WinningInfo.FIFTH, WinningInfo.getRankByMatchCountAndBonus(3, false));

        // 꽝
        assertNull(WinningInfo.getRankByMatchCountAndBonus(2, false));
        assertNull(WinningInfo.getRankByMatchCountAndBonus(1, true));
        assertNull(WinningInfo.getRankByMatchCountAndBonus(0, false));
    }
}
