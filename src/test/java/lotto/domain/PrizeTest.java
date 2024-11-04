package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PrizeTest {

    @ParameterizedTest
    @CsvSource({"FIRST_PLACE,FIRST_PLACE", "SECOND_PLACE,SECOND_PLACE", "THIRD_PLACE,THIRD_PLACE",
            "FOURTH_PLACE,FOURTH_PLACE", "FIFTH_PLACE,FIFTH_PLACE", "UNRANKED,UNRANKED"})
    @DisplayName("등수에 따라 상금 반환")
    void getPrizeByRank(Rank rank, Prize expected) {
        Prize actual = Prize.getPrizeByRank(rank);

        assertThat(actual).isEqualByComparingTo(expected);
    }
}