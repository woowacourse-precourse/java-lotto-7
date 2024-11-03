package lotto.application.statistics.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Rank - 당첨 등수")
class RankTest {

    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, NONE",
            "1, false, NONE",
            "0, false, NONE"
    })
    @DisplayName("일치하는 개수와 보너스 번호 일치 여부로 등수가 결정된다")
    void 일치개수랑_보너스번호로_등수결정(int matchCount, boolean matchBonus, Rank expected) {

        // when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        // then
        Assertions.assertThat(rank).isEqualTo(expected);
    }


}
