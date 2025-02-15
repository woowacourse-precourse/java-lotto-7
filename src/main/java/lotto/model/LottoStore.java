package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStore {
    public static final int LOTTO_PRICE = 1000;

    public int calculateLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    public Map<Prize, Integer> calculateResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Prize, Integer> prizeResults = new HashMap<>();

        for (Lotto lotto : lottos) {
            Prize prize = Prize.calculatePrize(lotto.getNumbers(), winningNumbers, bonusNumber);
            prizeResults.put(prize, prizeResults.getOrDefault(prize, 0) + 1);
        }
        return prizeResults;
    }
}
