package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("매치 수와 보너스 번호 여부에 따라 올바른 Rank가 반환된다.")
    @Test
    void of_ReturnsCorrectRank() {
        // 3개 일치
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
        // 4개 일치
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH);
        // 5개 일치
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
        // 5개 일치 + 보너스 번호 일치
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
        // 6개 일치
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
        // 일치 없음
        assertThat(Rank.of(2, false)).isEqualTo(Rank.NONE);
    }

    @DisplayName("매치 수가 음수이거나 초과하면 NONE을 반환한다.")
    @Test
    void of_InvalidMatchCount_ReturnsNone() {
        assertThat(Rank.of(-1, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.of(7, false)).isEqualTo(Rank.NONE);
    }
}
