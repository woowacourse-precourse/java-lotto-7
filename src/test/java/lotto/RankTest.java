package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RankTest {
    @Test
    @DisplayName("6개 일치 시 FIRST 등수가 반환된다.")
    void 일치하는_개수가_6개이면_FIRST_등수가_반환된다() {
        Rank rank = Rank.of(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 번호가 일치하면 SECOND 등수가 반환된다.")
    void 일치하는_개수가_5개이고_보너스가_일치하면_SECOND_등수가_반환된다() {
        Rank rank = Rank.of(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("5개 일치하고 보너스 번호가 일치하지 않으면 THIRD 등수가 반환된다.")
    void 일치하는_개수가_5개이고_보너스가_일치하지_않으면_THIRD_등수가_반환된다() {
        Rank rank = Rank.of(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("4개 일치 시 FOURTH 등수가 반환된다.")
    void 일치하는_개수가_4개이면_FOURTH_등수가_반환된다() {
        Rank rank = Rank.of(4, false);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3개 일치 시 FIFTH 등수가 반환된다.")
    void 일치하는_개수가_3개이면_FIFTH_등수가_반환된다() {
        Rank rank = Rank.of(3, false);
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("3개 미만 일치 시 NONE 등수가 반환된다.")
    void 일치하는_개수가_3개_미만이면_NONE_등수가_반환된다() {
        Rank rank1 = Rank.of(2, false);
        Rank rank2 = Rank.of(1, false);
        Rank rank3 = Rank.of(0, false);

        assertThat(rank1).isEqualTo(Rank.NONE);
        assertThat(rank2).isEqualTo(Rank.NONE);
        assertThat(rank3).isEqualTo(Rank.NONE);
    }
}