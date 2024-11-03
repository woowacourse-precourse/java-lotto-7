package lotto.service;

import lotto.domain.*;
import java.util.HashMap;
import java.util.List;

public class RankService {

    private final HashMap<Rank, Integer> ranking;
    private final int COUNT_ZERO = 0;
    private final int COUNT_ONE = 1;

    public RankService() {
        ranking = new HashMap<Rank, Integer>();
        for (Rank rank : Rank.values()) {
            ranking.put(rank, 0);
        }
    }

    public void checkRank(List<Lotto> lottos, List<Integer> winnings, int bonus) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNums = lotto.lottoNumbers();
            int winNums = checkWins(lottoNums, winnings);
            boolean bonusNum = checkBonus(lottoNums, bonus);
            Rank rank = MatchRank.matchRank(winNums, bonusNum);
            updateRanking(rank);
        }
    }

    private int checkWins(List<Integer> lottoNums, List<Integer> winnings) {
        int wins = COUNT_ZERO;
        for (int number : lottoNums) {
            if (winnings.contains(number)) {
                wins += COUNT_ONE;
            }
        }
        return wins;
    }

    private boolean checkBonus(List<Integer> lottoNums, int bonus) {
        if (lottoNums.contains(bonus)) {
            return true;
        }
        return false;
    }

    private void updateRanking(Rank rank) {
        ranking.put(rank, ranking.get(rank) + COUNT_ONE);
    }

    public int rankCount(Rank rank) {
        return ranking.get(rank);
    }

}
