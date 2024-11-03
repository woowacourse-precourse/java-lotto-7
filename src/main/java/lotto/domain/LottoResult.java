package lotto.domain;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LottoResult {
	private final Map<Rank, Integer> rankCount;
	private final String profitRate;

	private LottoResult(Map<Rank, Integer> rankCount, String profitRate) {
		this.rankCount = rankCount;
		this.profitRate = profitRate;
	}

	public static LottoResult of(Amount amount, PurchasedLottos purchasedLottos, WinningNumbers winningNumbers) {
		Map<Rank, Integer> rankCount = calculateRankCount(purchasedLottos, winningNumbers);
		String profitRate = calculateProfitRate(amount, rankCount);
		return new LottoResult(rankCount, profitRate);
	}

	public Map<Rank, Integer> getRankCount() {
		return rankCount;
	}

	public String getProfitRate() {
		return profitRate;
	}

	private static Map<Rank, Integer> calculateRankCount(PurchasedLottos purchasedLottos,
		WinningNumbers winningNumbers) {
		Map<Rank, Integer> rankCount = new TreeMap<>(Comparator.reverseOrder());
		List<Rank> originRanks = Rank.getRanks();
		originRanks.forEach(originRank -> rankCount.put(originRank, 0));

		List<Rank> ranks = purchasedLottos.compareWinningNumbers(winningNumbers);
		ranks.forEach(rank -> rankCount.merge(rank, 1, Integer::sum));
		return rankCount;
	}

	private static String calculateProfitRate(Amount amount, Map<Rank, Integer> rankCount) {
		double getAmount = amount.getAmount();
		double sum = rankCount.entrySet().stream()
			.mapToLong(e -> e.getKey().getMoney() * e.getValue())
			.sum();
		return String.format("%.1f", (sum / getAmount) * 100);
	}
}
