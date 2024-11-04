package lotto.model.statistic;

import static lotto.model.statistic.MatchList.FIVE_AND_BONUS_NUMBERS_MATCH;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Set;

public class Match {

    private final EnumMap<MatchList, Integer> matchResultByNumber;

    public Match(List<Integer> lottoNumbers, int bonusNumber, List<Set<Integer>> lottoResults) {
        matchResultByNumber = new EnumMap<>(MatchList.class);
        for (MatchList matchList : MatchList.values()) {
            matchResultByNumber.put(matchList, 0);
        }
        calculateStatistics(lottoNumbers, bonusNumber, lottoResults);
    }

    public int getMatchResult(final MatchList match) {
        return matchResultByNumber.get(match);
    }

    private void calculateStatistics(
            List<Integer> lottoNumbers,
            int bonusNumber,
            List<Set<Integer>> lottoResults
    ) {
        for (Set<Integer> lottoResult : lottoResults) {
            int numbersMatch = (int) lottoResult.stream().filter(lottoNumbers::contains).count();
            boolean bonusMatch = lottoResult.contains(bonusNumber);

            MatchList matchedCategory = findMatchCategory(numbersMatch, bonusMatch);
            if(matchedCategory != null) {
                matchResultByNumber.put(matchedCategory, matchResultByNumber.get(matchedCategory) + 1);
            }
        }
    }

    private MatchList findMatchCategory(int numbersMatch, boolean bonusMatch) {
        if (numbersMatch == 5 && bonusMatch) {
            return FIVE_AND_BONUS_NUMBERS_MATCH;
        }

        return Arrays.stream(MatchList.values())
                .filter(matchList -> matchList.getMatchNumber() == numbersMatch && !matchList.isBonusMatch())
                .findAny()
                .orElse(null);
    }
}
