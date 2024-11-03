package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WinningInfoTest {

    @Test
    void 각_등수의_등수_확인() {

        assertThat(WinningInfo.FIRST.getPlace())
                .isEqualTo(1);
        assertThat(WinningInfo.SECOND.getPlace())
                .isEqualTo(2);
        assertThat(WinningInfo.THIRD.getPlace())
                .isEqualTo(3);
        assertThat(WinningInfo.FOURTH.getPlace())
                .isEqualTo(4);
        assertThat(WinningInfo.FIFTH.getPlace())
                .isEqualTo(5);
    }

    @Test
    void 각_등수의_당첨번호_일치개수_확인() {

        assertThat(WinningInfo.FIRST.getMatchingNumberCount())
                .isEqualTo(6);
        assertThat(WinningInfo.SECOND.getMatchingNumberCount())
                .isEqualTo(5);
        assertThat(WinningInfo.THIRD.getMatchingNumberCount())
                .isEqualTo(5);
        assertThat(WinningInfo.FOURTH.getMatchingNumberCount())
                .isEqualTo(4);
        assertThat(WinningInfo.FIFTH.getMatchingNumberCount())
                .isEqualTo(3);
    }

    @Test
    void 일등의_당첨상금_확인() {

        assertThat(WinningInfo.FIRST.getPrizeMoney())
                .isEqualTo(2000000000);
        assertThat(WinningInfo.SECOND.getPrizeMoney())
                .isEqualTo(30000000);
        assertThat(WinningInfo.THIRD.getPrizeMoney())
                .isEqualTo(1500000);
        assertThat(WinningInfo.FOURTH.getPrizeMoney())
                .isEqualTo(50000);
        assertThat(WinningInfo.FIFTH.getPrizeMoney())
                .isEqualTo(5000);
    }

    @Test
    void 당첨시_해당_등수의_당첨티켓개수_확인() {

        WinningInfo.resetWinningTicketCount();
        for (WinningInfo info : WinningInfo.values()) {
            info.win();

            assertThat(info.getWinningTicketCount())
                    .isEqualTo(1);
        }
    }
}