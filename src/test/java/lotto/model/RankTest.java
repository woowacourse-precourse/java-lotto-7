package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class RankTest {
    @Test
    void 로또번호가_겹친횟수와_보너스번호의_겹침여부를_통해_등수를_계산한다() {
        Rank rank1 = Rank.from(6, false);
        Rank rank2 = Rank.from(5, true);
        Rank rank3 = Rank.from(5, false);
        Rank rank4 = Rank.from(0, true);

        assertThat(rank1).isEqualTo(Rank.FIRST);
        assertThat(rank2).isEqualTo(Rank.SECOND);
        assertThat(rank3).isEqualTo(Rank.THIRD);
        assertThat(rank4).isEqualTo(Rank.NONE);
    }
}
