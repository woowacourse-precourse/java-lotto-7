package lotto.user;

import java.util.EnumMap;
import java.util.Map;

import lotto.answer.LottoRank;

public class User {

	private Map<LottoRank, Integer> lottoStats = new EnumMap<>(LottoRank.class);
	private double rateOfReturn;

	public void updateRank(LottoRank rank) {
		lottoStats.put(rank, lottoStats.getOrDefault(rank, 0) + 1);
	}

	public void calculateRateOfReturns(int lottoPurchaseAmount) {
		int totals = 0;
		for (Map.Entry<LottoRank, Integer> lottoRankEntry : lottoStats.entrySet()) {
			totals += lottoRankEntry.getKey().getPrizeAmount() * lottoRankEntry.getValue();
		}
		rateOfReturn = (double) totals / lottoPurchaseAmount * 100;
	}
}
