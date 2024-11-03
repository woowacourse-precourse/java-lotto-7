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
import org.junit.jupiter.api.Test;

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

    @DisplayName("6개 번호가 모두 일치하는 경우")
    @Test
    void whenAllMatch() {
        LottoTickets lottoTickets = getFixedLottoTickets(List.of(1, 2, 3, 4, 5, 6));
        WinningResult winningResult = lottoResultEvaluator.evaluate(lottoTickets);

        assertEquals(winningResult.sixMatchesCount(), 1);
        assertEquals(winningResult.fiveWithBonusCount(), 0);
        assertEquals(winningResult.fiveMatchesCount(), 0);
        assertEquals(winningResult.fourMatchesCount(), 0);
        assertEquals(winningResult.threeMatchesCount(), 0);
        assertEquals(winningResult.totalYield(), 200_000_000.0);
    }

    @DisplayName("5개 번호가 일치하고 보너스 번호도 일치하는 경우")
    @Test
    void when5MatchAndBonusMatch() {
        LottoTickets lottoTickets = getFixedLottoTickets(List.of(1, 2, 3, 4, 5, 7));
        WinningResult winningResult = lottoResultEvaluator.evaluate(lottoTickets);

        assertEquals(winningResult.sixMatchesCount(), 0);
        assertEquals(winningResult.fiveWithBonusCount(), 1);
        assertEquals(winningResult.fiveMatchesCount(), 0);
        assertEquals(winningResult.fourMatchesCount(), 0);
        assertEquals(winningResult.threeMatchesCount(), 0);
        assertEquals(winningResult.totalYield(), 3_000_000.0);
    }

    @DisplayName("5개 번호가 일치하지만 보너스 번호는 일치하지 않는 경우")
    @Test
    void when5Match() {
        LottoTickets lottoTickets = getFixedLottoTickets(List.of(1, 2, 3, 4, 5, 45));
        WinningResult winningResult = lottoResultEvaluator.evaluate(lottoTickets);

        assertEquals(winningResult.sixMatchesCount(), 0);
        assertEquals(winningResult.fiveWithBonusCount(), 0);
        assertEquals(winningResult.fiveMatchesCount(), 1);
        assertEquals(winningResult.fourMatchesCount(), 0);
        assertEquals(winningResult.threeMatchesCount(), 0);
        assertEquals(winningResult.totalYield(), 150_000.0);
    }

    @DisplayName("4개 번호가 일치하는 경우")
    @Test
    void when4Match() {
        LottoTickets lottoTickets = getFixedLottoTickets(List.of(1, 2, 3, 4, 44, 45));
        WinningResult winningResult = lottoResultEvaluator.evaluate(lottoTickets);

        assertEquals(winningResult.sixMatchesCount(), 0);
        assertEquals(winningResult.fiveWithBonusCount(), 0);
        assertEquals(winningResult.fiveMatchesCount(), 0);
        assertEquals(winningResult.fourMatchesCount(), 1);
        assertEquals(winningResult.threeMatchesCount(), 0);
        assertEquals(winningResult.totalYield(), 5_000.0);
    }

    @DisplayName("3개 번호가 일치하는 경우")
    @Test
    void when3Match() {
        LottoTickets lottoTickets = getFixedLottoTickets(List.of(1, 2, 3, 43, 44, 45));
        WinningResult winningResult = lottoResultEvaluator.evaluate(lottoTickets);

        assertEquals(winningResult.sixMatchesCount(), 0);
        assertEquals(winningResult.fiveWithBonusCount(), 0);
        assertEquals(winningResult.fiveMatchesCount(), 0);
        assertEquals(winningResult.fourMatchesCount(), 0);
        assertEquals(winningResult.threeMatchesCount(), 1);
        assertEquals(winningResult.totalYield(), 500.0);
    }

    @DisplayName("일치하는 번호가 없는 경우")
    @Test
    void whenNotMatch() {
        LottoTickets lottoTickets = getFixedLottoTickets(List.of(40, 41, 42, 43, 44, 45));
        WinningResult winningResult = lottoResultEvaluator.evaluate(lottoTickets);

        assertEquals(winningResult.sixMatchesCount(), 0);
        assertEquals(winningResult.fiveWithBonusCount(), 0);
        assertEquals(winningResult.fiveMatchesCount(), 0);
        assertEquals(winningResult.fourMatchesCount(), 0);
        assertEquals(winningResult.threeMatchesCount(), 0);
        assertEquals(winningResult.totalYield(), 0.0);
    }

    private LottoTickets getFixedLottoTickets(List<Integer> lottoNumbers) {
        return new LottoTickets(
                List.of(new Lotto(lottoNumbers))
        );
    }
}
