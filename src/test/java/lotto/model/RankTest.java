package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("일치하는 번호와 보너스 여부에 따라 올바른 등수가 반환된다.")
    @ParameterizedTest(name = "{index}: matchCount={0}, matchBonus={1}, rank={2}")
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "4, true, FOURTH",
            "3, false, FIFTH",
            "2, false, NONE"
    })
    void 로또_당첨_등수_확인(int matchCount, boolean matchBonus, Rank rank) {
        Rank testRank = Rank.of(matchCount, matchBonus);
        assertThat(testRank).isEqualTo(rank);
    }
}
