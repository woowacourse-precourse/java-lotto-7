package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoMatcherTest {
    private LottoMatcher lottoMatcher;
    private WinningNumber winningNumber;

    @BeforeEach
    void setUp() {
        lottoMatcher = new LottoMatcher();
        winningNumber = new WinningNumber();
        winningNumber.setWinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        winningNumber.setBonusNumber(7);

    }

    @DisplayName("매치된 숫자 개수와 보너스 매치에 따른 등수를 확인한다.")
    @Test
    void 매치된_숫자와_보너스_매치에_따른_등수_확인() {
        // 6개 일치
        assertEquals(RankingEnum.SIX_MATCH, lottoMatcher.findRankByMatch(6, false));

        // 5개 일치 + 보너스 번호 일치
        assertEquals(RankingEnum.BONUS_MATCH, lottoMatcher.findRankByMatch(5, true));

        // 5개 일치
        assertEquals(RankingEnum.FIVE_MATCH, lottoMatcher.findRankByMatch(5, false));

        // 4개 일치
        assertEquals(RankingEnum.FOUR_MATCH, lottoMatcher.findRankByMatch(4, false));

        // 3개 일치
        assertEquals(RankingEnum.TREE_MATCH, lottoMatcher.findRankByMatch(3, false));

        // 2개 이하 일치 (등수 없음)
        assertNull(lottoMatcher.findRankByMatch(2, false));
    }

    @DisplayName("로또와 당첨번호를 비교하여 당첨 개수를 확인한다.")
    @Test
    void 로또_티켓과_당첨_번호_비교하여_당첨_개수_확인() {
        List<Lotto> lotteries = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10)),
                new Lotto(Arrays.asList(1, 2, 3, 11, 12, 13))
        );

        Map<RankingEnum, Long> result = lottoMatcher.matchCount(lotteries, winningNumber);

        assertEquals(1, result.getOrDefault(RankingEnum.SIX_MATCH, 0L));
        assertEquals(1, result.getOrDefault(RankingEnum.BONUS_MATCH, 0L));
        assertEquals(1, result.getOrDefault(RankingEnum.FIVE_MATCH, 0L));
        assertEquals(1, result.getOrDefault(RankingEnum.FOUR_MATCH, 0L));
        assertEquals(1, result.getOrDefault(RankingEnum.TREE_MATCH, 0L));
    }

    @DisplayName("구입금액과 당첨금으로 수익률을 계산한다.")
    @Test
    void 수익률_계산_확인() {
        Map<RankingEnum, Long> result = Map.of(
                RankingEnum.SIX_MATCH, 1L,
                RankingEnum.FIVE_MATCH, 2L
        );

        int totalSpent = 5000;
        double rateOfReturn = lottoMatcher .calculateRateOfReturn(result, totalSpent);

        double expectedRateOfReturn = ((2000000000 + 1500000 * 2) / 5000.0) * 100;
        expectedRateOfReturn = Math.round(expectedRateOfReturn * 10) / 10.0; // 소수점 둘째 자리 반올림

        assertEquals(expectedRateOfReturn, rateOfReturn);
    }
}