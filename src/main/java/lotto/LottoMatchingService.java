package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final Map<Rank, Integer> result = new LinkedHashMap<>();

    public double getResult(List<Integer> winningNumbers, int bonusNumber, int purchaseAmount) {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        for (Lotto lotto : LottoRepository.getInstance().findAll()) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean hasBonus = lotto.containsBonus(bonusNumber);

            Rank rank = Rank.calculateRank(matchCount, hasBonus);
            result.put(rank, result.get(rank) + 1);
        }

        int totalPrize = 0;
        for (Rank rank : result.keySet()) {
            int count = result.get(rank);
            totalPrize += rank.getPrize() * count;
        }

        double profitRate = ((double) totalPrize / purchaseAmount) * 100;

        return (double) Math.round(profitRate * 10) / 10.0;
    }

    public void printResult() {
        for (Rank key : result.keySet()) {
            if (key == Rank.NONE) {
                continue;
            }

            System.out.printf("%s (%,d원) - %d개%n", key.getMessage(), key.getPrize(),
                    result.get(key));
        }
    }
}
