package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> rankCounts = new HashMap<>();
    private final int totalPrize;

    public LottoResult(List<Lotto> userLottos, WinningLotto winningLotto) {
        for (Lotto userLotto : userLottos) {
            Rank rank = calculateResult(userLotto, winningLotto);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
        totalPrize = calculateTotalPrize();
    }

    public Rank calculateResult(Lotto userLotto, WinningLotto winningLotto) {
    	List<Integer> winningNumbers = winningLotto.getWinningNumbers();
    	int bonusNumber = winningLotto.getBonusNumber();
    	
        int matchCount = (int) userLotto.getNumbers().stream().filter(winningNumbers::contains).count();
        boolean matchBonus = userLotto.getNumbers().contains(bonusNumber);
        return Rank.calculateRank(matchCount, matchBonus);
    }

    private int calculateTotalPrize() {
        return rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public double calculateProfitRate(int purchaseAmount) {
        return ((double) totalPrize / purchaseAmount) * 100;
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }
}