package lotto.model.evaluate;

import static org.junit.jupiter.api.Assertions.*;

import lotto.dto.MatchInfo;
import lotto.dto.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 번호 매치 결과 수집 객체 테스트")
class LottoResultCollectorTest {

    private LottoResultCollector lottoResultCollector;

    @BeforeEach
    void setUp() {
        lottoResultCollector = new LottoResultCollector();
    }

    @DisplayName("일치 개수와 보너스 여부에 따른 결과가 정확히 증가된다.")
    @ParameterizedTest(name = "일치 개수: {0}, 보너스 여부: {1}, 3개: {2}, 4개: {3}, 5개: {4}, 5개+보너스: {5}, 6개: {6}")
    @CsvSource({
            "6, false, 0, 0, 0, 0, 1",
            "5, true,  0, 0, 0, 1, 0",
            "5, false, 0, 0, 1, 0, 0",
            "4, false, 0, 1, 0, 0, 0",
            "3, false, 1, 0, 0, 0, 0",
            "0, false, 0, 0, 0, 0, 0"
    })
    void testWinningResultWithMatchInfo(int matchesCount, boolean isBonusNumberMatch,
                                        int expectedThree, int expectedFour,
                                        int expectedFive, int expectedFiveBonus,
                                        int expectedSix) {
        MatchInfo matchInfo = new MatchInfo(matchesCount, isBonusNumberMatch);
        lottoResultCollector.increment(matchInfo);
        WinningResult winningResult = lottoResultCollector.createWinningResult(1);

        assertWinningResult(winningResult, expectedThree, expectedFour, expectedFive, expectedFiveBonus, expectedSix);
    }

    @DisplayName("규칙에 어긋나는 매칭 정보인 경우 아무것도 증가되지 않는다.")
    @ParameterizedTest(name = "일치 개수: {0}, 보너스 여부: {1}")
    @CsvSource({
            "0, true", "1, true",
            "2, true", "3, true",
            "4, true", "6, true"
    })
    void shouldNotIncrementForInvalidMatchInfo(int matchesCount, boolean isBonusNumberMatch) {
        MatchInfo matchInfo = new MatchInfo(matchesCount, isBonusNumberMatch);
        lottoResultCollector.increment(matchInfo);
        WinningResult winningResult = lottoResultCollector.createWinningResult(1);

        assertWinningResult(winningResult, 0, 0, 0, 0, 0);
    }

    private void assertWinningResult(WinningResult winningResult,
                                     int expectedThree,
                                     int expectedFour,
                                     int expectedFive,
                                     int expectedFiveBonus,
                                     int expectedSix) {
        assertEquals(expectedThree, winningResult.threeMatchesCount());
        assertEquals(expectedFour, winningResult.fourMatchesCount());
        assertEquals(expectedFive, winningResult.fiveMatchesCount());
        assertEquals(expectedFiveBonus, winningResult.fiveWithBonusCount());
        assertEquals(expectedSix, winningResult.sixMatchesCount());
    }
}
