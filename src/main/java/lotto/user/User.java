package lotto.user;

import java.util.EnumMap;
import java.util.Map;

import lotto.answer.LottoRank;

public class User {

	private Map<LottoRank, Integer> lottoStats = new EnumMap<>(LottoRank.class);
	private double rateOfReturn;
	private int lottoPurchaseAmount;

	public User() {
		for (LottoRank lottoRank : LottoRank.values()) {
			lottoStats.putIfAbsent(lottoRank, 0);
		}
	}

	public void updateRank(LottoRank rank) {
		lottoStats.put(rank, lottoStats.get(rank) + 1);
	}

	public void setLottoPurchaseAmount(int lottoPurchaseAmount) {
		this.lottoPurchaseAmount = lottoPurchaseAmount;
	}
	public void calculateRateOfReturns() {
		int totals = 0;
		for (Map.Entry<LottoRank, Integer> lottoRankEntry : lottoStats.entrySet()) {
			totals += lottoRankEntry.getKey().getPrizeAmount() * lottoRankEntry.getValue();
		}
		rateOfReturn = (double) totals / lottoPurchaseAmount * 100;
	}

	public void printResult() {
		System.out.println("lottoStats = " + lottoStats);
		for (Map.Entry<LottoRank, Integer> lottoRankEntry : lottoStats.entrySet()) {
			lottoRankEntry.getKey().printInfo(lottoRankEntry.getValue());
		}
		System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
	}
}
