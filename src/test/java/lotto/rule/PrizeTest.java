package lotto.rule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("당첨 내용 테스트")
class PrizeTest {

    @DisplayName("당첨 금액 테스트")
    @ParameterizedTest
    @CsvSource({
            "6, false, 2_000_000_000",
            "5, true, 30_000_000",
            "5, false, 1_500_000",
            "4, false, 50_000",
            "3, false, 5_000",
            "2, false, 0"
    })
    void dummy(int matchesCount, boolean isBonusMatches, long prizeAmount) {
        Prize prize = Prize.getPrizeByMatchInfo(matchesCount, isBonusMatches);
        assertEquals(prize.getPrizeAmount(), prizeAmount);
    }
}
