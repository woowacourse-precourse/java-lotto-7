package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("틀린 숫자의 개수가 0인 경우 1등 반환")
    @Test
    void 틀린_숫자의_개수가_0인_경우_1등_반환() {
        // given
        List<Integer> missedNumbers = List.of();
        int bonusNumber = 5;

        // when
        Rank rank = Rank.getRank(missedNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.FIRST);
    }

    @DisplayName("틀린 숫자의 개수가 1이고 보너스와 일치하는 경우 2등 반환")
    @Test
    void 틀린_숫자의_개수가_1이고_보너스와_일치하는_경우_2등_반환() {
        // given
        List<Integer> missedNumbers = List.of(5);
        int bonusNumber = 5;

        // when
        Rank rank = Rank.getRank(missedNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.SECOND);
    }

    @DisplayName("틀린 숫자의 개수가 1이고 보너스와 일치하지 않는 경우 3등 반환")
    @Test
    void 틀린_숫자의_개수가_1이고_보너스와_일치하는_경우_3등_반환() {
        // given
        List<Integer> missedNumbers = List.of(5);
        int bonusNumber = 6;

        // when
        Rank rank = Rank.getRank(missedNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.THIRD);
    }

    @DisplayName("틀린 숫자의 개수가 2인 경우 4등 반환")
    @Test
    void 틀린_숫자의_개수가_2인_경우_4등_반환() {
        // given
        List<Integer> missedNumbers = List.of(1, 2);
        int bonusNumber = 5;

        // when
        Rank rank = Rank.getRank(missedNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.FOURTH);
    }

    @DisplayName("틀린 숫자의 개수가 3인 경우 5등 반환")
    @Test
    void 틀린_숫자의_개수가_3인_경우_5등_반환() {
        // given
        List<Integer> missedNumbers = List.of(1, 2, 3);
        int bonusNumber = 5;

        // when
        Rank rank = Rank.getRank(missedNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.FIFTH);
    }

    @DisplayName("틀린 숫자의 개수가 3개 초과인 경우 낙첨 반환")
    @Test
    void 틀린_숫자의_개수가_3개_초과인_경우_낙첨_반환() {
        // given
        List<Integer> missedNumbers = List.of(1, 2, 3, 4);
        int bonusNumber = 5;

        // when
        Rank rank = Rank.getRank(missedNumbers, bonusNumber);

        // then
        assertThat(rank).isEqualByComparingTo(Rank.NO_PRIZE);
    }
}