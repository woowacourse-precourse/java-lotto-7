package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTableTest {

    @BeforeEach
    @DisplayName("당첨 카운트 초기화")
    void resetWinningCounts() throws Exception {
        for (PrizeTable prizeTable : PrizeTable.values()) {
            Field field = prizeTable.getClass().getDeclaredField("winningCount");
            field.setAccessible(true);
            field.set(prizeTable, 0);
        }
    }

    @Test
    void 당첨_카운트_증가_테스트() {
        PrizeTable prize = PrizeTable.THREE_MATCHES;

        prize.addWinningCount();
        prize.addWinningCount();

        assertEquals(2, prize.getWinningCount());
    }

    @Test
    void 총_상금_계산_테스트() {
        PrizeTable prize = PrizeTable.THREE_MATCHES;

        prize.addWinningCount();
        prize.addWinningCount();

        int expect = 2 * prize.getPrizeMoney();

        assertEquals(expect, prize.getTotalPrizeMoney());
    }

    @Test
    void 테이블_매칭_테스트() {
        assertEquals(5_000, PrizeTable.THREE_MATCHES.getPrizeMoney());
        assertEquals(3, PrizeTable.THREE_MATCHES.getMatchNumbers());

        assertEquals(50_000, PrizeTable.FOUR_MATCHES.getPrizeMoney());
        assertEquals(4, PrizeTable.FOUR_MATCHES.getMatchNumbers());

        assertEquals(1_500_000, PrizeTable.FIVE_MATCHES.getPrizeMoney());
        assertEquals(5, PrizeTable.FIVE_MATCHES.getMatchNumbers());

        assertEquals(30_000_000, PrizeTable.FIVE_BONUS_MATCHES.getPrizeMoney());
        assertEquals(5, PrizeTable.FIVE_BONUS_MATCHES.getMatchNumbers());

        assertEquals(2_000_000_000, PrizeTable.SIX_MATCHES.getPrizeMoney());
        assertEquals(6, PrizeTable.SIX_MATCHES.getMatchNumbers());
    }
}
