package lotto.domain;

import lotto.domain.enums.WinningStatistics;

import java.util.HashMap;
import java.util.Map;

public class ResultCount {

    private final Map<WinningStatistics, Integer> matchCountMap = new HashMap<>();

    private int totalNumber;
    private int threeMatches;
    private int fourMatches;
    private int fiveMatches;
    private int fiveMatchesWithBonus;
    private int sixMatches;

    public ResultCount() {

    }

    public void check(int cnt, boolean bonus) {

        if(cnt == 3)
            threeMatches++;
        if(cnt==4)
            fourMatches++;
        if(cnt==5 && !bonus)
            fiveMatches++;
        if(cnt==5 && bonus)
            fiveMatchesWithBonus++;
        if(cnt == 6)
            sixMatches++;

        totalNumber++;
    }

    public Map<WinningStatistics, Integer> getResults(){

        matchCountMap.put(WinningStatistics.THREE_MATCHES, threeMatches);
        matchCountMap.put(WinningStatistics.FOUR_MATCHES, fourMatches);
        matchCountMap.put(WinningStatistics.FIVE_MATCHES, fiveMatches);
        matchCountMap.put(WinningStatistics.FIVE_MATCHES_WITH_BONUS, fiveMatchesWithBonus);
        matchCountMap.put(WinningStatistics.SIX_MATCHES, sixMatches);

        return matchCountMap;
    }

    public float getReturnRate(int lottoPrize) {

        int totalPrize = 0;

        WinningStatistics[] grades = WinningStatistics.values();
        for(WinningStatistics grade : grades)
            totalPrize += matchCountMap.get(grade) * grade.getPrizeMoney();

        return (float) totalPrize / (totalNumber * lottoPrize);
    }
}
