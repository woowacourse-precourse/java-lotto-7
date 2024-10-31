package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @DisplayName("당첨 결과를 표기한다.")
    @Test
    void notateWinningResult() {
        //given
        WinningResult result = new WinningResult(Map.of(
            Rank.FIRST, 1,
            Rank.SECOND, 2,
            Rank.THIRD, 3,
            Rank.FOURTH, 4,
            Rank.FIFTH, 5,
            Rank.NONE, 0)
        );
        //when
        String notation = Rank.notationFrom(result);
        //then
        assertThat(notation)
            .isEqualTo(
                "6개 일치 (2,000,000,000원) - 1개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개\n" +
                    "5개 일치 (1,500,000원) - 3개\n" +
                    "4개 일치 (50,000원) - 4개\n" +
                    "3개 일치 (5,000원) - 5개\n"
            );
    }

    @DisplayName("당첨 개수와 보너스 볼 일치 여부에 따라 순위를 반환한다.")
    @ParameterizedTest
    @CsvSource({
        "6, true, FIRST",
        "6, false, FIRST",
        "5, true, SECOND",
        "5, false, THIRD",
        "4, false, FOURTH",
        "4, true, FOURTH",
        "3, false, FIFTH",
        "3, true, FIFTH",
        "2, false, NONE",
        "1, false, NONE",
    })
    void createRank(int matchCount, boolean isBonusMatch, Rank expected) {
        //given
        //when
        Rank rank = Rank.of(matchCount, isBonusMatch);
        //then
        assertThat(rank).isEqualTo(expected);
    }

}