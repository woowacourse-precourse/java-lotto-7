package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.MatchResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    List<MatchResult> lottoResults;
    LottoResult lottoResult;
    LottoResult lottoResult2;


    @BeforeEach
    void setUp() {
        lottoUtils = new LottoUtils();
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)),
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)),
                new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24)),
                new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24))
        );
        bonusNumber = 8;
        purchaseAmount = 8000;
        lottoResult = new LottoResult(winningNumbers, new Lotto(Arrays.asList(1, 2, 3, 9, 10, 11)), bonusNumber);
        lottoResult2 = new LottoResult(winningNumbers, new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)), bonusNumber);
        lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoResult result = new LottoResult(winningNumbers, lotto, bonusNumber);
            MatchResult matchResult = lottoUtils.determineMatchResult(result);
            lottoResults.add(matchResult);
        }
    }
    @Test
    void MatchCount의_갯수_반환_테스트() {
        Map<MatchResult, Integer> matchCounts = lottoUtils.countMatchResults(lottoResults);
        assertEquals(1, matchCounts.get(MatchResult.THREE_MATCH), "3개 일치 결과가 예상과 다릅니다.");
        assertEquals(0, matchCounts.get(MatchResult.FOUR_MATCH), "4개 일치 결과가 예상과 다릅니다.");
        assertEquals(0, matchCounts.get(MatchResult.SIX_MATCH), "6개 일치 결과가 예상과 다릅니다.");
        assertEquals(5, matchCounts.get(MatchResult.NONE), "일치하지 않는 결과 개수가 예상과 다릅니다.");
    }

    @Test
    void 당첨번호와_로또번호의_갯수가_일치하는_MatchCount_반환_테스트(){
        MatchResult matchResult = lottoUtils.determineMatchResult(lottoResult);
        MatchResult matchResult2 = lottoUtils.determineMatchResult(lottoResult2);
        assertEquals(MatchResult.THREE_MATCH, matchResult);
        assertEquals(MatchResult.NONE, matchResult2, "두 번째 결과가 예상과 다릅니다.");

    }

    @Test
    void 수익률_테스트() {
        Map<MatchResult, Integer> matchCounts = lottoUtils.countMatchResults(lottoResults);
        lottoUtils.calculateRateOfReturn(lottoResults, purchaseAmount);
        assertEquals(1, matchCounts.get(MatchResult.THREE_MATCH), "3개 일치 결과가 예상과 다릅니다.");
        assertEquals(0, matchCounts.get(MatchResult.FOUR_MATCH), "4개 일치 결과가 예상과 다릅니다.");
        assertEquals(0, matchCounts.get(MatchResult.FIVE_MATCH_BONUS), "5개 일치 보너스 결과가 예상과 다릅니다.");
        assertEquals(0, matchCounts.get(MatchResult.SIX_MATCH), "6개 일치 결과가 예상과 다릅니다.");

        double rateOfResult = (double) lottoUtils.totalPrize / purchaseAmount * 100;
        assertEquals(187.5, rateOfResult, "수익률 결과가 예상과 다릅니다.");
    }



}