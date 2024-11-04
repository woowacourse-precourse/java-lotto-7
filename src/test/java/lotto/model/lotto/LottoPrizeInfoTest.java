package lotto.model.lotto;

import lotto.model.lotto.prize.LottoPrizeInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPrizeInfoTest {

    @ParameterizedTest
    @CsvSource({
            "6, false, FIRST_PRIZE",
            "5, true, SECOND_PRIZE",
            "5, false, THIRD_PRIZE",
            "4, false, FOURTH_PRIZE",
            "3, false, FIFTH_PRIZE",
            "2, false, NONE",
            "0, false, NONE"
    })
    void 정확한_상금이_반환된다(int matchCount, boolean hasBonus, LottoPrizeInfo expectedPrize) {
        // Act
        LottoPrizeInfo prizeInfo = LottoPrizeInfo.getPrizeByMatch(matchCount, hasBonus);

        // Assert
        assertEquals(expectedPrize, prizeInfo,
                () -> String.format("matchCount=%d, bonusMatch=%b일 때 예상 상금 %d와 실제 상금 %d가 일치하지 않습니다.",
                        matchCount, hasBonus, expectedPrize, prizeInfo));
    }
}
