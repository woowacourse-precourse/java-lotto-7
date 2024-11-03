package lotto.model;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    @DisplayName("등수 반환")
    void of() {
        assertSimpleTest(() -> {
            Rank rank = Rank.of(6, false);
            assertThat(rank).isEqualTo(Rank.FIRST);
        });
        assertSimpleTest(() -> {
            Rank rank = Rank.of(5, true);
            assertThat(rank).isEqualTo(Rank.SECOND);
        });
        assertSimpleTest(() -> {
            Rank rank = Rank.of(5, false);
            assertThat(rank).isEqualTo(Rank.THIRD);
        });
        assertSimpleTest(() -> {
            Rank rank = Rank.of(4, false);
            assertThat(rank).isEqualTo(Rank.FOURTH);
        });
        assertSimpleTest(() -> {
            Rank rank = Rank.of(3, false);
            assertThat(rank).isEqualTo(Rank.FIFTH);
        });
    }
}
