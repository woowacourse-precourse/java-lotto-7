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

    @ParameterizedTest(name = "{index}: {1}")
    @MethodSource("prizeStringTest")
    @DisplayName("등수 문자열 변환 테스트")
    void prize_toStringTest(Prize prize, String message, String prizeString) {
        assertEquals(prize.toString(), prizeString);
    }

    static Stream<Arguments> prizeStringTest() {
        return Stream.of(
                Arguments.of(Prize.FIRST, "1등", "6개 일치 (2,000,000,000원)"),
                Arguments.of(Prize.SECOND, "2등", "5개 일치, 보너스 볼 일치 (30,000,000원)"),
                Arguments.of(Prize.THIRD, "3등", "5개 일치 (1,500,000원)"),
                Arguments.of(Prize.FOURTH, "4등", "4개 일치 (50,000원)"),
                Arguments.of(Prize.FIFTH, "5등", "3개 일치 (5,000원)")
        );
    }
}
