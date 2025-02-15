package lotto.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class PrizeTest {

    @Test
    void 세개일치시_THREE_프라이즈를_반환한다() {
        Prize prize = Prize.match(3, false);
        assertEquals(Prize.THREE, prize);
    }

    @Test
    void 네개일치시_FOUR_프라이즈를_반환한다() {
        Prize prize = Prize.match(4, false);
        assertEquals(Prize.FOUR, prize);
    }

    @Test
    void 다섯개일치하고_보너스일치시_FIVE_AND_BONUS_프라이즈를_반환한다() {
        Prize prize = Prize.match(5, true);
        assertEquals(Prize.FIVE_AND_BONUS, prize);
    }

    @Test
    void 다섯개일치하나_보너스불일치시_FIVE_프라이즈를_반환한다() {
        Prize prize = Prize.match(5, false);
        assertEquals(Prize.FIVE, prize);
    }

    @Test
    void 여섯개일치시_SIX_프라이즈를_반환한다() {
        Prize prize = Prize.match(6, false);
        assertEquals(Prize.SIX, prize);
    }

    @Test
    void 일치하지_않는_숫자일경우_null을_반환한다() {
        Prize prize = Prize.match(2, false);
        assertNull(prize);
    }
}
