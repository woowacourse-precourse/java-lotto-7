package lotto.application.statistics.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        assertThat(rank).isEqualTo(expected);
    }

    @DisplayName("등수별 상금 확인")
    @Test
    void 등수별_상금_확인() {

        //expect
        assertAll(
                () -> assertThat(Rank.FIRST.getPrize()).isEqualTo(2_000_000_000),
                () -> assertThat(Rank.SECOND.getPrize()).isEqualTo(30_000_000),
                () -> assertThat(Rank.THIRD.getPrize()).isEqualTo(1_500_000),
                () -> assertThat(Rank.FOURTH.getPrize()).isEqualTo(50_000),
                () -> assertThat(Rank.FIFTH.getPrize()).isEqualTo(5_000),
                () -> assertThat(Rank.NONE.getPrize()).isZero()
        );
    }

}
