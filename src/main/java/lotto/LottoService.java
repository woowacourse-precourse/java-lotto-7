package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    public Map<Integer, Integer> calcWinningStatistics(List<Lotto> lottoList, List<Integer> winningNumbers) {
        Map<Integer, Integer> winningStatistics = new HashMap<>();
        for (Lotto lotto : lottoList) {
            int rank = lotto.matchLotto(winningNumbers);
            if (rank <= 5) {
                winningStatistics.put(rank, winningStatistics.getOrDefault(rank, 0) + 1);
            }
        }
        return winningStatistics;
    }

    public double calcReturnRate(Map<Integer, Integer> winningStatistics, int lottoCount) {
        int prize = 0;
        for (int rank = 1; rank < 6; rank++) {
            prize += winningStatistics.getOrDefault(rank, 0) * getPrize(rank);
        }
        return prize / (double) lottoCount * 100;
    }


    private int getPrize(int rank) {
        if (rank == 1) {
            return Rank.FIFTH.getPrize();
        } else if (rank == 2) {
            return Rank.SECOND.getPrize();
        } else if (rank == 3) {
            return Rank.THIRD.getPrize();
        } else if (rank == 4) {
            return Rank.FOURTH.getPrize();
        } else if (rank == 5) {
            return Rank.FIFTH.getPrize();
        }
        return 0;
    }


}
