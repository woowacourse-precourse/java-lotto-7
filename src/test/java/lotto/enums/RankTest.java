package lotto.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("6개 수 일치")
    @Test
    void findFirstRank() {
        Rank rank = Rank.findRank(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("6개 수 + 보너스 수 일치")
    @Test
    void findFirstRank_bonus() {
        Rank rank = Rank.findRank(6, true);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("5개 수 + 보너스 수 일치")
    @Test
    void findSecondRank() {
        Rank rank = Rank.findRank(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("5개 수 일치")
    @Test
    void findThirdRank() {
        Rank rank = Rank.findRank(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("4개 수 일치")
    @Test
    void findFourthRank() {
        Rank rank = Rank.findRank(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("4개 수 + 보너스 수 일치")
    @Test
    void findFourthRank_bonus() {
        Rank rank = Rank.findRank(4, true);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("3개 수 일치")
    @Test
    void findFifthRank() {
        Rank rank = Rank.findRank(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("3개 수 + 보너스 수 일치")
    @Test
    void findFifthRank_bonus() {
        Rank rank = Rank.findRank(3, true);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @DisplayName("2개 수 일치")
    @Test
    void findNoneRank() {
        Rank rank = Rank.findRank(2, false);
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @DisplayName("2개 수 + 보너스 수 일치")
    @Test
    void findNoneRank_bonus() {
        Rank rank = Rank.findRank(2, true);
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @DisplayName("1개 수 일치")
    @Test
    void findNoneRank2() {
        Rank rank = Rank.findRank(1, false);
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @DisplayName("1개 수 + 보너스 수 일치")
    @Test
    void findNoneRank2_bonus() {
        Rank rank = Rank.findRank(1, true);
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @DisplayName("0개 수 일치")
    @Test
    void findNoneRank3() {
        Rank rank = Rank.findRank(0, false);
        assertThat(rank).isEqualTo(Rank.NONE);
    }

    @DisplayName("0개 수 + 보너스 수 일치")
    @Test
    void findNoneRank3_bonus() {
        Rank rank = Rank.findRank(0, true);
        assertThat(rank).isEqualTo(Rank.NONE);
    }
}
