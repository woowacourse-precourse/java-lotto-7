package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @ParameterizedTest
    @MethodSource("matchingCountProvider")
    void 로또_랭크_매칭카운트_테스트(Rank rank, int expectedCount) {
        assertEquals(expectedCount, rank.getMatchingCount());
    }

    static Object[][] matchingCountProvider() {
        return new Object[][] {
                { Rank.FIRST, 6 },
                { Rank.SECOND, 5 },
                { Rank.THIRD, 5 },
                { Rank.FOURTH, 4 },
                { Rank.FIFTH, 3 },
        };
    }

    @ParameterizedTest
    @MethodSource("prizeProvider")
    void 로또_랭크_상금_테스트(Rank rank, int expectedPrize) {
        assertEquals(expectedPrize, rank.calculateTotalPrize(1));
    }

    static Object[][] prizeProvider() {
        return new Object[][] {
                { Rank.FIRST, 2000000000 },
                { Rank.SECOND, 30000000 },
                { Rank.THIRD, 1500000 },
                { Rank.FOURTH, 50000 },
                { Rank.FIFTH, 5000 },
        };
    }

    @ParameterizedTest
    @MethodSource("rankDeterminationProvider")
    void 랭크_결정_테스트(int matchingCount, boolean hasBonus, Rank expectedRank) {
        assertEquals(expectedRank, Rank.determineRank(matchingCount, hasBonus));
    }

    static Object[][] rankDeterminationProvider() {
        return new Object[][] {
                { 6, false, Rank.FIRST },
                { 5, true, Rank.SECOND },
                { 5, false, Rank.THIRD },
                { 4, false, Rank.FOURTH },
                { 3, false, Rank.FIFTH },
                { 0, false, Rank.NONE },
        };
    }
}
