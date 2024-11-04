package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WinningTest {

    @Test
    void 번호가_6개_일치하면_보너스_번호와_상관없이_1등이다() {
        // given
        int matchCount = 6;
        boolean isBonusNumberMatched = false;

        // when
        Winning rank = Winning.getRank(matchCount, isBonusNumberMatched);

        // then
        assertEquals(rank, Winning.FIRST);
    }

    @Test
    void 번호가_5개_일치하고_보너스_번호가_일치하면_2등이다() {
        // given
        int matchCount = 5;
        boolean isBonusNumberMatched = true;

        // when
        Winning rank = Winning.getRank(matchCount, isBonusNumberMatched);

        // then
        assertEquals(rank, Winning.SECOND);
    }

    @Test
    void 번호가_5개_일치하고_보너스_번호가_일치하지_않으면_3등이다() {
        // given
        int matchCount = 5;
        boolean isBonusNumberMatched = false;

        // when
        Winning rank = Winning.getRank(matchCount, isBonusNumberMatched);

        // then
        assertEquals(rank, Winning.THIRD);
    }

    @Test
    void 번호가_4개_일치하면_보너스_번호와_상관없이_4등이다() {
        // given
        int matchCount = 4;
        boolean isBonusNumberMatched = true;

        // when
        Winning rank = Winning.getRank(matchCount, isBonusNumberMatched);

        // then
        assertEquals(rank, Winning.FOURTH);
    }

    @Test
    void 번호가_3개_일치하면_보너스_번호와_상관없이_5등이다() {
        // given
        int matchCount = 3;
        boolean isBonusNumberMatched = true;

        // when
        Winning rank = Winning.getRank(matchCount, isBonusNumberMatched);

        // then
        assertEquals(rank, Winning.FIFTH);
    }

    @Test
    void 번호가_2개_일치하면_보너스_번호와_상관없이_꽝이다() {
        // given
        int matchCount = 2;
        boolean isBonusNumberMatched = false;

        // when
        Winning rank = Winning.getRank(matchCount, isBonusNumberMatched);

        // then
        assertEquals(rank, Winning.NONE);
    }
}