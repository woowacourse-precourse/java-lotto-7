package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRankTest {

    @Test
    @DisplayName("당첨 개수와 보너스 번호에 따라 올바른 값이 반환된다.")
    void winningRank_정상적인_등급_반환() {
        // Given
        int matchCount = 5;
        boolean matchBonus = false;

        // When
        WinningRank rank = WinningRank.valueOf(matchCount, matchBonus);

        // Then
        assertThat(rank).isEqualTo(WinningRank.THIRD_PLACE);
    }

    @Test
    @DisplayName("5개 숫자 일치 + 보너스 번호 일치 시 2등 반환")
    void winningRank_5개일치_보너스일치() {
        // Given
        int matchCount = 5;
        boolean matchBonus = true;

        // When
        WinningRank rank = WinningRank.valueOf(matchCount, matchBonus);

        // Then
        assertThat(rank).isEqualTo(WinningRank.SECOND_PLACE);
    }

    @Test
    @DisplayName("6개 숫자 일치 시 3등 반환")
    void winningRank_6개일치() {
        // Given
        int matchCount = 6;
        boolean matchBonus = false;

        // When
        WinningRank rank = WinningRank.valueOf(matchCount, matchBonus);

        // Then
        assertThat(rank).isEqualTo(WinningRank.FIRST_PLACE);
    }

    @Test
    @DisplayName("0개 숫자 일치 시 꼴등 반환")
    void winningRank_0개일치() {
        // Given
        int matchCount = 0;
        boolean matchBonus = false;

        // When
        WinningRank rank = WinningRank.valueOf(matchCount, matchBonus);

        // Then
        assertThat(rank).isEqualTo(WinningRank.LAST_PLACE);
    }
}
