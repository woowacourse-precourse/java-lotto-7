package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    public Rank getLottoResult(Lotto lotto, List<Integer> winningNumbers, int bonus) {
        int numberMatch = 0;
        boolean hasBonus = false;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                numberMatch++;
            }
            if (number == bonus) {
                hasBonus = true;
            }
        }
        return Rank.getRank(numberMatch, hasBonus);
    }

    public Map<Rank, Integer> getFinalResult(List<Lotto> lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        for (Lotto lotto : lottoTickets) {
            Rank rank = getLottoResult(lotto, winningNumbers, bonusNumber);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    public float getTotalProfit(Map<Rank, Integer> result) {
        float totalProfit = 0;
        for (Rank rank : Rank.values()) {
            totalProfit += rank.getPrize() * result.get(rank);
        }
        return totalProfit;
    }

}
