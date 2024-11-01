package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.Rank;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoResultTest {

    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, false, FOURTH",
            "3, false, FIFTH",
            "2, false, MISS",
            "1, false, MISS",
            "0, false, MISS"
    })
    void testRankOf(int matchCount, boolean hasBonusNumber, Rank expectedRank) {
        // when
        Rank lottoResult = Rank.of(matchCount, hasBonusNumber);

        // then
        assertEquals(expectedRank, lottoResult);
    }
}
