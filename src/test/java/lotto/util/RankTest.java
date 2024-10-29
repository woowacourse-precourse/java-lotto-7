package lotto.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    public void 일등() {
        Rank result = Rank.fromMatchCount(6, false);
        assertEquals(Rank.FIRST, result);
    }

    @Test
    public void 이등() {
        Rank result = Rank.fromMatchCount(5, true);
        assertEquals(Rank.SECOND, result);
    }

    @Test
    public void 삼등() {
        Rank result = Rank.fromMatchCount(5, false);
        assertEquals(Rank.THIRD, result);
    }

    @Test
    public void 사등() {
        Rank result = Rank.fromMatchCount(4, false);
        assertEquals(Rank.FOURTH, result);
    }

    @Test
    public void 오등() {
        Rank result = Rank.fromMatchCount(3, false);
        assertEquals(Rank.FIFTH, result);
    }

    @Test
    public void 당첨되지않음() {
        Rank result = Rank.fromMatchCount(2, false);
        assertEquals(Rank.NONE, result);
    }
}
