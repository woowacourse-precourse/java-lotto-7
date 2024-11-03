package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoProcess {

    public static void statisticalWork(LottoManager manager, List<Integer> winningNumber, int bonusNumber, Map<LottoRank, Integer> winningStatistics) {
        for (Lotto lotto : manager.getLottos()) {
            int count = intersectionCalculation(lotto, winningNumber);
            boolean bonus = isBonus(lotto, bonusNumber);
            LottoRank rank = getLottoRank(count, bonus);
            updateRank(rank, winningStatistics);
        }
    }

    private static void updateRank(LottoRank rank, Map<LottoRank, Integer> winningStatistics) {
        if (rank != null) {
            winningStatistics.put(rank, winningStatistics.get(rank) + 1);
        }
    }

    private static LottoRank getLottoRank(int count, boolean bonus) {
        return LottoRank.getLottoRank(count, bonus);
    }

    private static boolean isBonus(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private static int intersectionCalculation(Lotto lotto, List<Integer> winningNumber) {
        List<Integer> intersection = new ArrayList<>(winningNumber);
        intersection.retainAll(lotto.getNumbers());
        return intersection.size();
    }


}
