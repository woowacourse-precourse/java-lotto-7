package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PrizeTest {

    @ParameterizedTest(name = "{index}: {2}")
    @MethodSource("prizeTest")
    @DisplayName("당첨 테스트")
    void prize_findByHitAndBonusTest(int hit, boolean bonus, String message, Prize prize) {
        assertEquals(Prize.findByHitAndBonus(hit, bonus), prize);
    }

    static Stream<Arguments> prizeTest() {
        return Stream.of(
                Arguments.of(6, false, "6개 일치", Prize.FIRST),
                Arguments.of(5, true, "5개 일치 & 보너스 o", Prize.SECOND),
                Arguments.of(5, false, "5개 일치 & 보너스 x", Prize.THIRD),
                Arguments.of(4, false, "4개 일치 & 보너스 x", Prize.FOURTH),
                Arguments.of(3, true, "3개 일치 & 보너스 o", Prize.FIFTH),
                Arguments.of(2, false, "2개 일치 & 보너스 x", null),
                Arguments.of(0, true, "0개 일치 & 보너스 o", null)
        );
    }
}
