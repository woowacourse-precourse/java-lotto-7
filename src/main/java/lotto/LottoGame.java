package lotto;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private Lotto winningLotto;
    private int bonusNumber;
    private final Map<LottoRank,Integer> result = new HashMap<>();

    public void setLottoGame(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public void calculateLotto(List<Lotto> makePurchasedLottos) {
        for (Lotto lotto : makePurchasedLottos) {
            LottoRank rank = makeRank(lotto);
            if (rank != null) {
                upDateRank(rank);
            }
        }
    }

    private LottoRank makeRank(Lotto lotto) {
        int matchCount = lotto.getMatchCount(winningLotto);
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    private void upDateRank(LottoRank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public double rateOfReturn(int lottoPurchase) {
        int totalPrize = calculateTotalPrize();
        return (double) totalPrize / lottoPurchase * 100;
    }

    private int calculateTotalPrize() {
        int totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : result.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            int prize = rank.getPrize();

            totalPrize += prize * count;
        }
        return totalPrize;
    }

}
