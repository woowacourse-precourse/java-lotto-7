package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.MatchResult;

import java.util.ArrayList;
import java.util.List;

public class LottoUtils {

    int lottoRateOfReturn = 0;
    ArrayList<MatchResult> lottoResults = new ArrayList<>();

    public void calculateWinningResult(List<Integer> winning, List<Lotto> lottos, int bonus) {
        createLottoResults(winning, lottos, bonus);

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
            return null;
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
