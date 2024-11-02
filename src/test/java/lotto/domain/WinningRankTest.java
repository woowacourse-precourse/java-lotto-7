package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRankTest {

    @DisplayName("매치카운트와 보너스매치가 1등에 부합할 때 True이다.")
    @Test
    void 매치카운트_보너스매치_1등_True() {
        assertThat(WinningRank.FIRST.isMatch(6, false)).isTrue();
    }

    @DisplayName("매치카운트와 보너스매치가 2등에 부합할 때 True이다.")
    @Test
    void 매치카운트_보너스매치_2등_True() {
        assertThat(WinningRank.SECOND.isMatch(5, false)).isFalse();
    }

    @DisplayName("매치카운트와 보너스매치가 2등에 부합하지 않을 때 False이다.")
    @Test
    void 매치카운트_보너스매치_2등_False() {
        assertThat(WinningRank.THIRD.isMatch(5, true)).isTrue();
    }

    @DisplayName("매치카운트와 보너스매치가 3등에 부합할 때 True이다.")
    @Test
    void 매치카운트_보너스매치_3등_True() {
        assertThat(WinningRank.THIRD.isMatch(5, false)).isTrue();
    }

    @DisplayName("매치카운트와 보너스매치가 4등에 부합할 때 True이다.")
    @Test
    void 매치카운트_보너스매치_4등_True() {
        assertThat(WinningRank.FOURTH.isMatch(4, false)).isTrue();
    }

    @DisplayName("매치카운트와 보너스매치가 5등에 부합할 때 True이다.")
    @Test
    void 매치카운트_보너스매치_5등_True() {
        assertThat(WinningRank.FIFTH.isMatch(3, false)).isTrue();
    }

}