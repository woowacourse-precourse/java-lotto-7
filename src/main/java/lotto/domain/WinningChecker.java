package lotto.domain;

import java.util.List;
import java.util.Map;

public class WinningChecker {
    public Map<String, Integer> checkWinning(Bonus bonus, Lotto lotto, List<List<Integer>> userLottos) {
        Map<String, Integer> lottoRankCount = LottoRank.LottoRankCollector();

        for (List<Integer> userLotto : userLottos) {
            int matchCount = lotto.matching(userLotto);
            boolean matchBonus = bonus.matching(userLotto);
            String rank = LottoRank.valueOf(matchCount, matchBonus);
            if (rank == "NONE") {
                continue;
            }
            lottoRankCount.put(rank, lottoRankCount.get(rank) + 1);
        }
        return lottoRankCount;
    }

    public static double calculateReturn(Map<String, Integer> matchingResult, int ticketNumbers) {
        double sum = 0;
        for (LottoRank rank : LottoRank.values()) {
            sum += rank.getPrize() * matchingResult.get(rank.name());
        }
        double result = sum / (ticketNumbers * 1000) * 100;
        return result;
    }

}
