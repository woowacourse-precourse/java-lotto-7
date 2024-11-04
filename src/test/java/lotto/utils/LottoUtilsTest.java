package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.MatchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class LottoUtilsTest {

    LottoUtils lottoUtils = new LottoUtils();
    List<Integer> winningNumbers;
    List<Lotto> lottos;
    int purchaseAmount;
    int bonusNumber;


    @BeforeEach
    void setUp() {
        lottoUtils = new LottoUtils();
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24))

        );
        bonusNumber = 8;
        purchaseAmount = 8000;
    }

    @Test
    void 로또_결과_계산_테스트() {
        lottoUtils.calculateWinningResult(winningNumbers, lottos, bonusNumber, purchaseAmount);
        assertEquals(6, lottoUtils.lottoResults.size(), "로또 결과 개수가 맞지 않습니다.");
        assertEquals(MatchResult.THREE_MATCH, lottoUtils.lottoResults.get(0), "첫 번째 로또 결과가 예상과 다릅니다.");
        assertEquals(MatchResult.NONE, lottoUtils.lottoResults.get(1), "두 번째 로또 결과가 예상과 다릅니다.");
        assertEquals(MatchResult.NONE, lottoUtils.lottoResults.get(2), "세 번째 로또 결과가 예상과 다릅니다.");
        assertEquals(MatchResult.NONE, lottoUtils.lottoResults.get(3), "네 번째 로또 결과가 예상과 다릅니다.");
        assertEquals(MatchResult.NONE, lottoUtils.lottoResults.get(4), "다섯 번째 로또 결과가 예상과 다릅니다.");
        assertEquals(MatchResult.NONE, lottoUtils.lottoResults.get(5), "여섯 번째 로또 결과가 예상과 다릅니다.");
    }

    @Test
    void 당첨_통계와_수익률_테스트() {
        lottoUtils.calculateWinningResult(winningNumbers, lottos, bonusNumber, purchaseAmount);

        Map<MatchResult, Integer> matchCounts = lottoUtils.countMatchResults();
        assertEquals(1, matchCounts.get(MatchResult.THREE_MATCH), "3개 일치 결과가 예상과 다릅니다.");
        assertEquals(0, matchCounts.get(MatchResult.FOUR_MATCH), "4개 일치 결과가 예상과 다릅니다.");
        assertEquals(0, matchCounts.get(MatchResult.FIVE_MATCH_BONUS), "5개 일치 보너스 결과가 예상과 다릅니다.");
        assertEquals(0, matchCounts.get(MatchResult.SIX_MATCH), "6개 일치 결과가 예상과 다릅니다.");

        double rateOfResult = (double) lottoUtils.totalPrize / purchaseAmount * 100;
        assertEquals(62.5, rateOfResult, "수익률 결과가 예상과 다릅니다.");

    }



}