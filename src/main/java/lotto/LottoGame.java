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
            int matchCount = lotto.getMatchCount(winningLotto);
            boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
            LottoRank rank = LottoRank.valueOf(matchCount, matchBonus);

            if (rank != null) {
                result.put(rank, result.getOrDefault(rank, 0) + 1);
            }
        }
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public double rateOfReturn(int lottoPurchase) {

        int total = 0;

        for (Map.Entry<LottoRank, Integer> entry : result.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            int prize = rank.getPrize();

            total += prize * count;
        }

        return (double) total / lottoPurchase * 100;

    }
}
