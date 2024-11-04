package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoRank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {

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
    void 번호_일치_여부에_따라_등수를_계산한다(int matchCount, boolean isBonusMatched, LottoRank expectedRank) {
        // when
        LottoRank resultRank = LottoRank.findRankByMatches(matchCount, isBonusMatched);

        // then
        assertThat(resultRank).isEqualTo(expectedRank);
    }
}
