package lotto;

import static lotto.Rank.FIRST;
import static lotto.Rank.SECOND;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRecordTest {
    @DisplayName("WinningRecord는_파라미터로_받은_Rank의_당첨_횟수를_반환할_수_있다")
    @Test
    public void getRankCount() {
        //given
        WinningRecord winningRecord = new WinningRecord();
        Rank rank = FIRST;
        winningRecord.put(rank);

        //when
        int result = winningRecord.getRankCount(rank);

        //then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("WinningRecord는_당첨되지_않은_Rank에_대해_기본_값인_0을_반환할_수_있다")
    @Test
    public void get_Default_RankCount() {
        //given
        WinningRecord winningRecord = new WinningRecord();

        //when
        int result = winningRecord.getRankCount(SECOND);

        //then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("WinningRecord는_당첨_정보로_총_당첨_금액을_계산하여_반환할_수_있다")
    @Test
    public void calculateTotalWinningAmount() {
        //given
        WinningRecord winningRecord = new WinningRecord();
        winningRecord.put(FIRST);
        winningRecord.put(SECOND);

        int expected = FIRST.getWinningAmount() + SECOND.getWinningAmount();

        //when
        int result = winningRecord.calculateTotalWinningAmount();

        //then
        assertThat(result).isEqualTo(expected);
    }
}