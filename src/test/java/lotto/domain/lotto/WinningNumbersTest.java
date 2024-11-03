package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumbersTest {

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
    void 랭크는_올바르게_나와야한다(int matchCount, boolean hasBonusNumber, Rank expectedRank) {
        // when
        Rank lottoResult = Rank.of(matchCount, hasBonusNumber);

        // then
        assertEquals(expectedRank, lottoResult);
    }

}
