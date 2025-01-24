package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoDrawer {
    private final List<List<Integer>> lottos;
    private final List<Integer> winningLottoNumbers;
    private final int bonusNumber;

    public LottoDrawer(List<List<Integer>> lottos, List<Integer> winningLottoNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningPrize, Integer> checkWinningNumbers() {
        Map<WinningPrize, Integer> rank = new HashMap<>();

        for (List<Integer> lotto : lottos) {
            int winningCount = 0;
            int bonusCount = 0;
            WinningPrize nowPrize = WinningPrize.getPrize(winningCountResult(lotto, winningCount),
                    bonusCountResult(lotto, bonusCount));
            makeNowRank(rank, nowPrize);
        }
        return rank;
    }

    private void makeNowRank(Map<WinningPrize, Integer> rank, WinningPrize nowPrize) {
        if (rank.get(nowPrize) != null) {
            rank.put(nowPrize, rank.get(nowPrize) + 1);
        }
        rank.putIfAbsent(nowPrize, 1);
    }


    private int winningCountResult(List<Integer> lottos, int winningCount) {
        for (Integer lotto : lottos) {
            winningCount += (int) winningLottoNumbers
                    .stream()
                    .filter(e -> e.equals(lotto))
                    .distinct()
                    .count();
        }
        return winningCount;
    }

    private int bonusCountResult(List<Integer> lottos, int bonusCount) {
        bonusCount += (int) lottos
                .stream()
                .filter(e -> e.equals(bonusNumber))
                .distinct()
                .count();
        return bonusCount;
    }
}
