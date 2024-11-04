package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    void 당첨되지_않은_경우_테스트_1() {
        Prize prize = Prize.determinePrize(0, false);

        assertNotNull(prize);
        assertEquals(Prize.EMPTY, prize);
    }

    @Test
    void 당첨되지_않은_경우_테스트_2() {
        Prize prize = Prize.determinePrize(1, true);

        assertNotNull(prize);
        assertEquals(Prize.EMPTY, prize);
    }

    @Test
    void 당첨되지_않은_경우_테스트_3() {
        Prize prize = Prize.determinePrize(2, false);

        assertNotNull(prize);
        assertEquals(Prize.EMPTY, prize);
    }

    @Test
    void 세_개_일치_테스트_1() {
        Prize prize = Prize.determinePrize(3, false);

        assertNotNull(prize);
        assertEquals(Prize.THREE_MATCH, prize);
    }

    @Test
    void 세_개_일치_테스트_2() {
        Prize prize = Prize.determinePrize(3, true);

        assertNotNull(prize);
        assertEquals(Prize.THREE_MATCH, prize);
    }

    @Test
    void 네_개_일치_테스트_1() {
        Prize prize = Prize.determinePrize(4, false);

        assertNotNull(prize);
        assertEquals(Prize.FOUR_MATCH, prize);
    }

    @Test
    void 네_개_일치_테스트_2() {
        Prize prize = Prize.determinePrize(4, true);

        assertNotNull(prize);
        assertEquals(Prize.FOUR_MATCH, prize);
    }

    @Test
    void 다섯_개_일치_보너스볼_불포함_테스트() {
        Prize prize = Prize.determinePrize(5, false);

        assertNotNull(prize);
        assertEquals(Prize.FIVE_MATCH_WITHOUT_BONUS_BALL, prize);
    }

    @Test
    void 다섯_개_일치_보너스볼_포함_테스트() {
        Prize prize = Prize.determinePrize(5, true);

        assertNotNull(prize);
        assertEquals(Prize.FIVE_MATCH_WITH_BONUS_BALL, prize);
    }

    @Test
    void 여섯_개_일치_테스트_1() {
        Prize prize = Prize.determinePrize(6, false);

        assertNotNull(prize);
        assertEquals(Prize.SIX_MATCH, prize);
    }

    @Test
    void 여섯_개_일치_테스트_2() {
        Prize prize = Prize.determinePrize(6, true);

        assertNotNull(prize);
        assertEquals(Prize.SIX_MATCH, prize);
    }
}