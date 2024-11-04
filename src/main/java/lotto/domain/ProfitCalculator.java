package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class ProfitCalculator {

    public Map<Ranking, Integer> getWinningInfo(Lottos lottos, WinningBonus winningBonus) {
        Map<Ranking, Integer> winningInfo = generateWinningInfo();
    }

    public Map<Ranking, Integer> generateWinningInfo() {
        Map<Ranking, Integer> winningInfo = new EnumMap<>(Ranking.class);
        Arrays.stream(Ranking.values()).forEach(ranking -> winningInfo.put(ranking, 0));
        return winningInfo;
    }
}
