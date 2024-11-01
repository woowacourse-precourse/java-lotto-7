package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 당첨번호가_6개_일치하면_FIRST_등급으로_분류한다() {
        Rank rank = Rank.findRank(6, false);
        assertThat(Rank.FIRST).isEqualTo(rank);
    }

    @Test
    void 당첨번호가_5개_일치하고_보너스_일치하면_SECOND_등급으로_분류한다() {
        Rank second = Rank.findRank(5, true);
        assertThat(Rank.SECOND).isEqualTo(second);
    }

    @Test
    void 당첨번호가_5개_일치하고_보너스_불일치하면_THIRD_등급으로_분류한다() {
        Rank third = Rank.findRank(5, false);
        assertThat(Rank.THIRD).isEqualTo(third);
    }

    @Test
    void 당첨번호가_4개_일치하면_FOURTH_등급으로_분류한다() {
        Rank rank = Rank.findRank(4, false);
        assertThat(Rank.FOURTH).isEqualTo(rank);
    }

    @Test
    void 당첨번호가_3개_일치하면_FIFTH_등급으로_분류한다() {
        Rank rank = Rank.findRank(3, false);
        assertThat(Rank.FIFTH).isEqualTo(rank);
    }

    @Test
    void 예외_테스트_당첨번호가_2개_일치하면_NONE으로_분류한다() {
        Rank rank = Rank.findRank(2, false);
        assertThat(Rank.NONE).isEqualTo(rank);
    }

    @Test
    void 예외_테스트_일치하는_숫자의_개수가_정상범위를_벗어나면_NONE_등수를_반환한다() {
        Rank rank = Rank.findRank(100, false);
        assertThat(Rank.NONE).isEqualTo(rank);
    }

    @Test
    void 예외_테스트_보너스_번호가_있어도_일치하는_개수가_5개가_아니면_NONE으로_분류한다() {
        Rank rank = Rank.findRank(2, true);
        assertThat(Rank.NONE).isEqualTo(rank);
    }
}