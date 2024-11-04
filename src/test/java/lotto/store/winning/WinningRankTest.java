package lotto.store.winning;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WinningRankTest {

    @Test
    void 당첨_번호의_개수와_보너스_번호_포함_여부가_일치하는_등수를_반환한다() {
        //given
        int matchCount = 5;
        boolean matchBonus = false;

        //when
        WinningRank winningRank = WinningRank.getWinningRank(matchCount, matchBonus);

        //then
        assertThat(winningRank).isEqualTo(WinningRank.THIRD);
    }

    @Test
    void 당첨_번호의_개수와_보너스_번호_포함_여부가_일치하는_등수가_없다면_꽝을_반환한다() {
        //given
        int matchCount = 0;
        boolean matchBonus = true;

        //when
        WinningRank winningRank = WinningRank.getWinningRank(matchCount, matchBonus);

        //then
        assertThat(winningRank).isEqualTo(WinningRank.NOTHING);
    }


}
