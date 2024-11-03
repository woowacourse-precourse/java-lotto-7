package lotto.core.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WinningRankTest {

    @Test
    void match_rank_1_should_be_pass() {
        // given
        // when
        int matchCount = 6;
        boolean matchBonus = true;
        WinningRank rank =  WinningRank.match(matchCount, matchBonus);
        // then
        Assertions.assertEquals(WinningRank.RANK_1, rank);
    }

    @Test
    void match_rank_2_should_be_pass() {
        // given
        // when
        int matchCount = 5;
        boolean matchBonus = true;
        WinningRank rank =  WinningRank.match(matchCount, matchBonus);
        // then
        Assertions.assertEquals(WinningRank.RANK_2, rank);
    }

    @Test
    void match_rank_3_should_be_pass() {
        // given
        // when
        int matchCount = 5;
        boolean matchBonus = false;
        WinningRank rank =  WinningRank.match(matchCount, matchBonus);
        // then
        Assertions.assertEquals(WinningRank.RANK_3, rank);
    }

    @Test
    void match_rank_4_should_be_pass() {
        // given
        // when
        int matchCount = 4;
        boolean matchBonus = true;
        WinningRank rank =  WinningRank.match(matchCount, matchBonus);
        // then
        Assertions.assertEquals(WinningRank.RANK_4, rank);
    }

    @Test
    void match_rank_5_should_be_pass() {
        // given
        // when
        int matchCount = 3;
        boolean matchBonus = true;
        WinningRank rank =  WinningRank.match(matchCount, matchBonus);
        // then
        Assertions.assertEquals(WinningRank.RANK_5, rank);
    }

    @Test
    void is_not_match_should_be_pass() {
        // given
        // when
        int matchCount = 0;
        boolean matchBonus = true;
        WinningRank rank =  WinningRank.match(matchCount, matchBonus);
        // then
        Assertions.assertNull(rank);
    }
}
