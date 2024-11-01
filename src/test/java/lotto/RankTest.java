package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 일치하는_숫자의_개수와_보너스_여부를_입력_받아서_등수를_반환한다() {
        Rank rank = Rank.findRank(3, false);
        assertThat(Rank.FIFTH).isEqualTo(rank);
    }

    @Test
    void 일치하는_숫자의_개수가_5개면_보너스_여부로_등수를_결정한다() {
        Rank second = Rank.findRank(5, true);
        Rank third = Rank.findRank(5, false);
        assertThat(Rank.SECOND).isEqualTo(second);
        assertThat(Rank.THIRD).isEqualTo(third);
    }

    @Test
    void 예외_테스트_일치하는_숫자의_개수가_없으면_NONE_등수를_반환한다() {
        Rank rank = Rank.findRank(100, false);
        assertThat(Rank.NONE).isEqualTo(rank);
    }

}