package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ResultTest {
    @Test
    public void FIRST_Result를_찾는다() {
        int matchCount = 6;
        boolean isBonusMatch = false;

        Result result = Result.findResult(matchCount, isBonusMatch);

        assertEquals(Result.FIRST, result);
    }

    @Test
    public void SECOND_Result를_찾는다() {
        int matchCount = 5;
        boolean isBonusMatch = true;

        Result result = Result.findResult(matchCount, isBonusMatch);

        assertEquals(Result.SECOND, result);
    }

    @Test
    public void THIRD_Result를_찾는다() {
        int matchCount = 5;
        boolean isBonusMatch = false;

        Result result = Result.findResult(matchCount, isBonusMatch);

        assertEquals(Result.THIRD, result);
    }

    @Test
    public void FORTH_Result를_찾는다() {
        int matchCount = 4;
        boolean isBonusMatch = false;

        Result result = Result.findResult(matchCount, isBonusMatch);

        assertEquals(Result.FORTH, result);
    }

    @Test
    public void FIFTH_Result를_찾는다() {
        int matchCount = 3;
        boolean isBonusMatch = false;

        Result result = Result.findResult(matchCount, isBonusMatch);

        assertEquals(Result.FIFTH, result);
    }

    @Test
    public void NOTHING_Result를_찾는다() {
        int matchCount = 2;
        boolean isBonusMatch = false;

        Result result = Result.findResult(matchCount, isBonusMatch);

        assertEquals(Result.NOTHING, result);
    }

    @Test
    public void NOTHING_Result를_찾는다2() {
        int matchCount = 0;
        boolean isBonusMatch = false;

        Result result = Result.findResult(matchCount, isBonusMatch);

        assertEquals(Result.NOTHING, result);
    }
}
