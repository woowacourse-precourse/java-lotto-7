package lotto.model.evaluate;

import static org.junit.jupiter.api.Assertions.*;

import lotto.dto.MatchInfo;
import lotto.dto.WinningResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 번호 매치 결과 카운터 객체 테스트")
class LottoResultCollectorTest {

    @DisplayName("6개 번호가 모두 일치하는 경우")
    @Test
    void whenAllMatch() {
        MatchInfo matchInfo = new MatchInfo(6, false);

        LottoResultCollector lottoResultCollector = new LottoResultCollector();
        lottoResultCollector.increment(matchInfo);

        WinningResult winningResult = lottoResultCollector.createWinningResult(1);

        assertEquals(winningResult.threeMatchesCount(), 0);
        assertEquals(winningResult.fourMatchesCount(), 0);
        assertEquals(winningResult.fiveMatchesCount(), 0);
        assertEquals(winningResult.fiveWithBonusCount(), 0);
        assertEquals(winningResult.sixMatchesCount(), 1);
    }

    @DisplayName("5개 번호가 일치하고 보너스 번호도 일치하는 경우")
    @Test
    void when5MatchAndBonusMatch() {
        MatchInfo matchInfo = new MatchInfo(5, true);

        LottoResultCollector lottoResultCollector = new LottoResultCollector();
        lottoResultCollector.increment(matchInfo);

        WinningResult winningResult = lottoResultCollector.createWinningResult(1);

        assertEquals(winningResult.threeMatchesCount(), 0);
        assertEquals(winningResult.fourMatchesCount(), 0);
        assertEquals(winningResult.fiveMatchesCount(), 0);
        assertEquals(winningResult.fiveWithBonusCount(), 1);
        assertEquals(winningResult.sixMatchesCount(), 0);
    }

    @DisplayName("5개 번호가 일치하지만 보너스 번호는 일치하지 않는 경우")
    @Test
    void when5Match() {
        MatchInfo matchInfo = new MatchInfo(5, false);

        LottoResultCollector lottoResultCollector = new LottoResultCollector();
        lottoResultCollector.increment(matchInfo);

        WinningResult winningResult = lottoResultCollector.createWinningResult(1);

        assertEquals(winningResult.threeMatchesCount(), 0);
        assertEquals(winningResult.fourMatchesCount(), 0);
        assertEquals(winningResult.fiveMatchesCount(), 1);
        assertEquals(winningResult.fiveWithBonusCount(), 0);
        assertEquals(winningResult.sixMatchesCount(), 0);
    }

    @DisplayName("4개 번호가 일치하는 경우")
    @Test
    void when4Match() {
        MatchInfo matchInfo = new MatchInfo(4, false);

        LottoResultCollector lottoResultCollector = new LottoResultCollector();
        lottoResultCollector.increment(matchInfo);

        WinningResult winningResult = lottoResultCollector.createWinningResult(1);

        assertEquals(winningResult.threeMatchesCount(), 0);
        assertEquals(winningResult.fourMatchesCount(), 1);
        assertEquals(winningResult.fiveMatchesCount(), 0);
        assertEquals(winningResult.fiveWithBonusCount(), 0);
        assertEquals(winningResult.sixMatchesCount(), 0);
    }

    @DisplayName("3개 번호가 일치하는 경우")
    @Test
    void when3Match() {
        MatchInfo matchInfo = new MatchInfo(3, false);

        LottoResultCollector lottoResultCollector = new LottoResultCollector();
        lottoResultCollector.increment(matchInfo);

        WinningResult winningResult = lottoResultCollector.createWinningResult(1);

        assertEquals(winningResult.threeMatchesCount(), 1);
        assertEquals(winningResult.fourMatchesCount(), 0);
        assertEquals(winningResult.fiveMatchesCount(), 0);
        assertEquals(winningResult.fiveWithBonusCount(), 0);
        assertEquals(winningResult.sixMatchesCount(), 0);
    }

    @DisplayName("일치하는 번호가 없는 경우")
    @Test
    void whenNotMatch() {
        MatchInfo matchInfo = new MatchInfo(0, false);

        LottoResultCollector lottoResultCollector = new LottoResultCollector();
        lottoResultCollector.increment(matchInfo);

        WinningResult winningResult = lottoResultCollector.createWinningResult(1);

        assertEquals(winningResult.threeMatchesCount(), 0);
        assertEquals(winningResult.fourMatchesCount(), 0);
        assertEquals(winningResult.fiveMatchesCount(), 0);
        assertEquals(winningResult.fiveWithBonusCount(), 0);
        assertEquals(winningResult.sixMatchesCount(), 0);
    }

    @DisplayName("규칙에 어긋나는 매칭 정보인 경우 아무것도 증가되지 않는다.")
    @ParameterizedTest
    @CsvSource({
            "0, true",
            "1, true",
            "2, true",
            "3, true",
            "4, true",
            "6, true"
    })
    void shouldReturnNotMatch_whenInvalidMatchInfo(int matchesCount, boolean isBonusNumberMatch) {
        MatchInfo matchInfo = new MatchInfo(matchesCount, isBonusNumberMatch);

        LottoResultCollector lottoResultCollector = new LottoResultCollector();
        lottoResultCollector.increment(matchInfo);

        WinningResult winningResult = lottoResultCollector.createWinningResult(1);

        assertEquals(winningResult.threeMatchesCount(), 0);
        assertEquals(winningResult.fourMatchesCount(), 0);
        assertEquals(winningResult.fiveMatchesCount(), 0);
        assertEquals(winningResult.fiveWithBonusCount(), 0);
        assertEquals(winningResult.sixMatchesCount(), 0);
    }
}
