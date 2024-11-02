package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;

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
}
