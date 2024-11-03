package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningRankTest {

    @ParameterizedTest
    @CsvSource({
            "FIRST_RANK, 6, false",
            "SECOND_RANK, 5, true",
            "THIRD_RANK, 5, false",
            "FOURTH_RANK, 4, true", "FOURTH_RANK, 4, false",
            "FIFTH_RANK, 3, true", "FIFTH_RANK, 3, false",
            "NOTHING, 2, true", "NOTHING, 0, false"})
    void findRankTest(WinningRank expected, int matchCount, boolean isBonusMatch) {
        WinningRank actual = WinningRank.findRank(matchCount, isBonusMatch);

        assertThat(actual).isEqualTo(expected);
    }
}
