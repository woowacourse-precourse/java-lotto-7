package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.MatchResult;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoUtils {

    int totalPrize = 0;
    ArrayList<MatchResult> lottoResults = new ArrayList<>();

    public void calculateWinningResult(List<Integer> winning, List<Lotto> lottos, int bonus, int purchaseAmount) {
        createLottoResults(winning, lottos, bonus);
        Map<MatchResult, Integer> matchResultMap = countMatchResults();
        printMatchResults(matchResultMap);
    }

    Map<MatchResult, Integer> countMatchResults() {
        Map<MatchResult, Integer> matchCounts = new EnumMap<>(MatchResult.class);
        for (MatchResult matchResult : MatchResult.values()){
            matchCounts.put(matchResult, 0);}
        for (MatchResult matchResult : lottoResults){
            matchCounts.put(matchResult, matchCounts.get(matchResult) + 1);
        }
        return matchCounts;
    }

    private void printMatchResults(Map<MatchResult, Integer> matchResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + matchResult.get(MatchResult.THREE_MATCH) + "개");
        System.out.println("4개 일치 (50,000원) - " + matchResult.get(MatchResult.FOUR_MATCH) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + matchResult.get(MatchResult.FIVE_MATCH) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + matchResult.get(MatchResult.FIVE_MATCH_BONUS) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + matchResult.get(MatchResult.SIX_MATCH) + "개");
    }

    private void createLottoResults(List<Integer> winning, List<Lotto> lottos, int bonus) {
        for (int i = 0; i < lottos.size(); i++) {
            LottoResult lottoResult = new LottoResult(winning, lottos.get(i), bonus);
            MatchResult matchResult = determineMatchResult(lottoResult);
            lottoResults.add(matchResult);
        }
    }

    private MatchResult determineMatchResult(LottoResult lottoResult){
        if (lottoResult.matchingCount() < 3){
            return MatchResult.NONE;
        }
        if (lottoResult.matchingCount() == 3) {
            return MatchResult.THREE_MATCH;
        }
        if (lottoResult.matchingCount() == 4){
            return MatchResult.FOUR_MATCH;
        }
        if (lottoResult.matchingCount() == 5) {
            return bonusContain(lottoResult);
        }
        return MatchResult.SIX_MATCH;
    }

    private MatchResult bonusContain(LottoResult lottoResult) {
        if(lottoResult.bonusMatch()){
            return MatchResult.FIVE_MATCH_BONUS;
        }
        return MatchResult.FIVE_MATCH;
    }
}
