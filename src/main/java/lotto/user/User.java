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
}
