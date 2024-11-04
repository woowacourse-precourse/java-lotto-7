package lotto.model.evaluate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.dto.WinningResult;
import lotto.model.ticket.Lotto;
import lotto.model.ticket.LottoTickets;
import lotto.model.win.BonusNumber;
import lotto.model.win.LottoWinningSet;
import lotto.model.win.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 결과 평가 객체 테스트")
class LottoResultEvaluatorTest {

    private LottoResultEvaluator lottoResultEvaluator;

    @BeforeEach
    void setUp() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        LottoWinningSet lottoWinningSet = new LottoWinningSet(winningNumbers, bonusNumber);
        lottoResultEvaluator = new LottoResultEvaluator(lottoWinningSet);
    }

    @DisplayName("매칭 결과에 따른 당첨 결과와 수익률을 검증한다.")
    @ParameterizedTest(name = "일치 개수: {0}, 보너스 일치 여부: {1}")
    @CsvSource({
            // 숫자, 매칭 결과, 수익률 구분을 위한 공백
            "1,2,3,4,5,6,       1,0,0,0,0, 200000000.0",
            "1,2,3,4,5,7,       0,1,0,0,0, 3000000.0",
            "1,2,3,4,5,45,      0,0,1,0,0, 150000.0",
            "1,2,3,4,44,45,     0,0,0,1,0, 5000.0",
            "1,2,3,43,44,45,    0,0,0,0,1, 500.0",
            "40,41,42,43,44,45, 0,0,0,0,0, 0.0"
    })
    void testWinningResultWithMatchInfo(int num1, int num2, int num3, int num4, int num5, int num6,
                                        int expectedSix, int expectedFiveBonus, int expectedFive,
                                        int expectedFour, int expectedThree, double expectedYield) {
        LottoTickets lottoTickets = getFixedLottoTickets(List.of(num1, num2, num3, num4, num5, num6));
        WinningResult winningResult = lottoResultEvaluator.evaluate(lottoTickets);

        assertWinningResult(
                winningResult,
                expectedSix,
                expectedFiveBonus,
                expectedFive,
                expectedFour,
                expectedThree,
                expectedYield
        );
    }

    private LottoTickets getFixedLottoTickets(List<Integer> lottoNumbers) {
        return new LottoTickets(List.of(new Lotto(lottoNumbers)));
    }

    private void assertWinningResult(WinningResult winningResult,
                                     int expectedSix,
                                     int expectedFiveBonus,
                                     int expectedFive,
                                     int expectedFour,
                                     int expectedThree,
                                     double expectedYield) {
        assertEquals(expectedSix, winningResult.sixMatchesCount());
        assertEquals(expectedFiveBonus, winningResult.fiveWithBonusCount());
        assertEquals(expectedFive, winningResult.fiveMatchesCount());
        assertEquals(expectedFour, winningResult.fourMatchesCount());
        assertEquals(expectedThree, winningResult.threeMatchesCount());
        assertEquals(expectedYield, winningResult.totalYield());
    }
}
