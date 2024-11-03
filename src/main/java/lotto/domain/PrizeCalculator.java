package lotto.domain;

import java.util.Map;

public class PrizeCalculator {

	private static final int PERCENTAGE_UNIT = 100;

	public double calculateYieldAsPercentage(int purchaseAmount, Map<Prize, Integer> prizes) {
		long totalPrizeMoney = calculateTotalPrize(prizes);

		return totalPrizeMoney * PERCENTAGE_UNIT / (double)purchaseAmount;
	}

	private long calculateTotalPrize(Map<Prize, Integer> prizes) {
		return prizes.keySet().stream()
			.mapToLong(prize -> prizes.get(prize) * prize.getPrizeMoney())
			.sum();
	}

}
