package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void 각_등수_확인() {
        assertThat(Rank.getRank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.getRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.getRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.getRank(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.getRank(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 각_등수_상금_확인() {
        assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000);
        assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000);
        assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000);
        assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000);
        assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000);
    }

    @Test
    void 등수가_없을_경우_null_반환() {
        assertThat(Rank.getRank(2, false)).isNull();
        assertThat(Rank.getRank(1, true)).isNull();
        assertThat(Rank.getRank(0, false)).isNull();
    }
}