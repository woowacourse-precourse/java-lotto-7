package lotto.model.statistic;

import static lotto.model.statistic.MatchList.FIVE_AND_BONUS_NUMBERS_MATCH;
import static lotto.model.statistic.MatchList.FIVE_NUMBERS_MATCH;
import static lotto.model.statistic.MatchList.FOUR_NUMBERS_MATCH;
import static lotto.model.statistic.MatchList.SIX_NUMBERS_MATCH;
import static lotto.model.statistic.MatchList.THREE_NUMBERS_MATCH;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Match {

    private final Map<MatchList, Integer> matchResultByNumber;

    public Match(List<Integer> lottoNumbers, int bonusNumber, List<Set<Integer>> lottoResults) {
        matchResultByNumber = new HashMap<>();
        matchResultByNumber.put(THREE_NUMBERS_MATCH, 0);
        matchResultByNumber.put(FOUR_NUMBERS_MATCH, 0);
        matchResultByNumber.put(FIVE_AND_BONUS_NUMBERS_MATCH, 0);
        matchResultByNumber.put(FIVE_NUMBERS_MATCH, 0);
        matchResultByNumber.put(SIX_NUMBERS_MATCH, 0);
        calculateStatistics(lottoNumbers, bonusNumber, lottoResults);
    }

    private void calculateStatistics(List<Integer> lottoNumbers, int bonusNumber, List<Set<Integer>> lottoResults) {
        for (Set<Integer> set : lottoResults) {
            addResult(set, lottoNumbers, bonusNumber);
        }
    }

    private void addResult(Set<Integer> set, List<Integer> lottoNumbers, int bonusNumber) {
        int numbersMatch = (int) set.stream().filter(lottoNumbers::contains).count();
        boolean bonusMatch = false;

        if (set.contains(bonusNumber)) {
            numbersMatch++;
            bonusMatch = true;
        }

        switch (numbersMatch) {
            case 3:
                matchRegistration(THREE_NUMBERS_MATCH);
                break;
            case 4:
                matchRegistration(FOUR_NUMBERS_MATCH);
                break;
            case 5:
                matchRegistration(FIVE_NUMBERS_MATCH);
                break;
            case 6:
                if (bonusMatch) {
                    matchRegistration(FIVE_AND_BONUS_NUMBERS_MATCH);
                    break;
                }
                matchRegistration(SIX_NUMBERS_MATCH);
                break;
        }
    }

    private void matchRegistration(final MatchList match) {
        matchResultByNumber.put(match, matchResultByNumber.get(match) + 1);
    }

    public int getMatchResult(final MatchList match) {
        return matchResultByNumber.get(match);
    }
}
