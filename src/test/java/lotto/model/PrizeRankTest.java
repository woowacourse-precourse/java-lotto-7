package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrizeRankTest {
    @Test
    @DisplayName("Get correct prize rank based on matching numbers and bonus match")
    void testValueOf() {
        // Test for FIFTH rank with 3 matching numbers and no bonus
        assertEquals(PrizeRank.FIFTH, PrizeRank.valueOf(3, false));

        // Test for FOURTH rank with 4 matching numbers and no bonus
        assertEquals(PrizeRank.FOURTH, PrizeRank.valueOf(4, false));

        // Test for THIRD rank with 5 matching numbers and no bonus
        assertEquals(PrizeRank.THIRD, PrizeRank.valueOf(5, false));

        // Test for SECOND rank with 5 matching numbers and bonus
        assertEquals(PrizeRank.SECOND, PrizeRank.valueOf(5, true));

        // Test for FIRST rank with 6 matching numbers and no bonus
        assertEquals(PrizeRank.FIRST, PrizeRank.valueOf(6, false));

        // Test for invalid case (must return null)
        assertNull(PrizeRank.valueOf(2, false));
    }

    @Test
    @DisplayName("Verify PrizeRank properties: matching numbers, bonus requirement, and prize amount")
    void testPrizeRankProperties() {
        assertAll(
                () -> assertEquals(3, PrizeRank.FIFTH.getMatchingNumbers()),
                () -> assertFalse(PrizeRank.FIFTH.requiresBonus()),
                () -> assertEquals(5_000, PrizeRank.FIFTH.getPrizeAmount()),

                () -> assertEquals(4, PrizeRank.FOURTH.getMatchingNumbers()),
                () -> assertFalse(PrizeRank.FOURTH.requiresBonus()),
                () -> assertEquals(50_000, PrizeRank.FOURTH.getPrizeAmount()),

                () -> assertEquals(5, PrizeRank.THIRD.getMatchingNumbers()),
                () -> assertFalse(PrizeRank.THIRD.requiresBonus()),
                () -> assertEquals(1_500_000, PrizeRank.THIRD.getPrizeAmount()),

                () -> assertEquals(5, PrizeRank.SECOND.getMatchingNumbers()),
                () -> assertTrue(PrizeRank.SECOND.requiresBonus()),
                () -> assertEquals(30_000_000, PrizeRank.SECOND.getPrizeAmount()),

                () -> assertEquals(6, PrizeRank.FIRST.getMatchingNumbers()),
                () -> assertFalse(PrizeRank.FIRST.requiresBonus()),
                () -> assertEquals(2_000_000_000, PrizeRank.FIRST.getPrizeAmount())
        );
    }
}
