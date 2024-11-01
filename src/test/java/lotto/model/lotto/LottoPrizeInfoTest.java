package lotto.model.lotto;

import lotto.model.lotto.LottoPrizeInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeInfoTest {

    @ParameterizedTest
    @CsvSource({
            "6, false, 2000000000",
            "5, true, 30000000",
            "5, false, 1500000",
            "4, false, 50000",
            "3, false, 5000",
            "2, false, 0",
            "0, false, 0"
    })
    void calculatePrize_정확한_상금이_반환된다(int matchCount, boolean bonusMatch, long expectedPrize) {
        // Act
        long prize = LottoPrizeInfo.calculatePrize(matchCount, bonusMatch);

        // Assert
        assertEquals(expectedPrize, prize,
                () -> String.format("matchCount=%d, bonusMatch=%b일 때 예상 상금 %d와 실제 상금 %d가 일치하지 않습니다.",
                        matchCount, bonusMatch, expectedPrize, prize));
    }
}
