package lotto;

import java.util.HashMap;
import java.util.Map.Entry;

public class LottoResult {
    HashMap<MatchStatus, Integer> matchCount;
    double revenueRatio;

    public LottoResult() {
        matchCount = new HashMap<> ();
        for (MatchStatus status : MatchStatus.values()){
            matchCount.put(status, 0);
        }
    }

    public void addMatchCount(int matchNumberCount, boolean hasBonus) {
        MatchStatus status = MatchStatus.getMatch(matchNumberCount, hasBonus);
        matchCount.put(status, matchCount.get(status) + 1);
    }

    public void calculate(int money) {
        long totalRevenue = 0;
        for (Entry<MatchStatus, Integer> type : matchCount.entrySet()) {
            totalRevenue += (long) type.getValue() * MatchStatus.getRevenue(type.getKey());
        }
        double ratio = ((double) totalRevenue / money) * 100;
        this.revenueRatio = Math.round(ratio * 100) / 100.0;
    }
}
