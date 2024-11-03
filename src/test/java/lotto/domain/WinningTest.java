package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {

    @Test
    void 당첨횟수_카운트() {
        // given
        Winning winning = new Winning();
        Rank rank = Rank.RANK_1;

        // when
        winning.increaseWinningCount(rank);

        // then
        assertThat(winning.getCount(rank)).isEqualTo(1);
        assertThat(winning.getCount(Rank.RANK_2)).isEqualTo(0);
    }

    @Test
    void Rank가_정렬되어_잘_불러오는지_확인() {
        // given
        Winning winning = new Winning();

        // when
        List<Rank> allRanks = winning.getAllRanks();

        // then
        assertThat(allRanks).doesNotContain(Rank.RANK_LOSE);
        assertThat(allRanks).isSortedAccordingTo(Comparator.comparingInt(Rank::ordinal));
    }

    @Test
    void rank에_맞는_상금금액_반환() {
        Winning winning = new Winning();
        Rank rank = Rank.RANK_1;
        for (int i = 0; i < 3; i++) {
            winning.increaseWinningCount(rank);
        }

        // when
        long prize = winning.getPrizeOfRank(rank);

        // then
        assertThat(prize).isEqualTo(6_000_000_000L);
    }

}