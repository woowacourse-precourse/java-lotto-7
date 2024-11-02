package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RankTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("6개의 번호가 일치하면 1등이 반환된다.")
        void matchSixNumbers() {
            // given & when
            Rank rank = Rank.valueOf(6, false);

            // then
            assertThat(rank).isEqualTo(Rank.FIRST_PLACE);
        }

        @Test
        @DisplayName("5개의 번호가 일치하고 보너스가 일치하면 2등이 반환된다.")
        void matchFiveNumbersWithBonus() {
            // given & when
            Rank rank = Rank.valueOf(5, true);

            // then
            assertThat(rank).isEqualTo(Rank.SECOND_PLACE);
        }

        @Test
        @DisplayName("5개의 번호가 일치하고 보너스가 없으면 3등이 반환된다.")
        void matchFiveNumbersWithoutBonus() {
            // given & when
            Rank rank = Rank.valueOf(5, false);

            // then
            assertThat(rank).isEqualTo(Rank.THIRD_PLACE);
        }

        @Test
        @DisplayName("4개의 번호가 일치하면 4등이 반환된다.")
        void matchFourNumbers() {
            // given & when
            Rank rank = Rank.valueOf(4, false);

            // then
            assertThat(rank).isEqualTo(Rank.FOURTH_PLACE);
        }

        @Test
        @DisplayName("3개의 번호가 일치하면 5등이 반환된다.")
        void matchThreeNumbers() {
            // given & when
            Rank rank = Rank.valueOf(3, false);

            // then
            assertThat(rank).isEqualTo(Rank.FIFTH_PLACE);
        }

        @Test
        @DisplayName("일치하는 번호가 2개 이하이면 미당첨이 반환된다.")
        void matchLessThanThreeNumbers() {
            // given & when
            Rank rank = Rank.valueOf(2, false);

            // then
            assertThat(rank).isEqualTo(Rank.NO_WIN);
        }
    }
}
