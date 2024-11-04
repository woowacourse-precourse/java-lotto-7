package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlaceTest {
    @Test
    void 상금_조건_금액_확인() {
        assertEquals(2_000_000_000, Place.FIRST.prize);
        assertEquals(30_000_000, Place.SECOND.prize);
        assertEquals(1_500_000, Place.THIRD.prize);
        assertEquals(50_000, Place.FOURTH.prize);
        assertEquals(5_000, Place.FIFTH.prize);
        assertEquals(0, Place.MISS.prize);

        assertEquals(6, Place.FIRST.needHitCount);
        assertEquals(5, Place.SECOND.needHitCount);
        assertEquals(5, Place.THIRD.needHitCount);
        assertEquals(4, Place.FOURTH.needHitCount);
        assertEquals(3, Place.FIFTH.needHitCount);
        assertEquals(0, Place.MISS.needHitCount);

        assertFalse(Place.FIRST.needHitBonusNumber);
        assertTrue(Place.SECOND.needHitBonusNumber);
        assertFalse(Place.THIRD.needHitBonusNumber);
        assertFalse(Place.FOURTH.needHitBonusNumber);
        assertFalse(Place.FIFTH.needHitBonusNumber);
        assertFalse(Place.MISS.needHitBonusNumber);
    }
}