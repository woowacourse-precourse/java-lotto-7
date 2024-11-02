package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankTest {

    @ParameterizedTest
    @CsvSource(value = {
            "6, true, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "0, false, NONE"
    })
    void 등수를_구한다(int count, boolean isMatchBonusNumber, Rank expectedRank) {
        assertThat(Rank.determine(count, isMatchBonusNumber)).isEqualTo(expectedRank);
    }

    @Test
    void 등수에_대한_결과를_초기화한다() {
        assertThat(Rank.initializeRankSummary()).contains(entry(Rank.FIRST, 0),
                entry(Rank.SECOND, 0),
                entry(Rank.THIRD, 0),
                entry(Rank.FOURTH, 0),
                entry(Rank.FIFTH, 0)
        );
    }
}
