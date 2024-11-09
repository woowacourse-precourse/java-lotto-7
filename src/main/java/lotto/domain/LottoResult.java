package lotto.domain;

import static lotto.domain.enums.Prize.*;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.domain.enums.Prize;

public class LottoResult {

	private final Map<Prize, Long> matchCounts;

	public LottoResult(List<Prize> prizes) {
		this.matchCounts = new EnumMap<>(Prize.class);

		for (Prize prize : values()) {
			if (prize != NO_MATCH) {
				matchCounts.put(prize, 0L);
			}
		}

		prizes.forEach(prize -> {
			if (prize != NO_MATCH) {
				matchCounts.put(prize, matchCounts.get(prize) + 1);
			}
		});
	}

	public Map<Prize, Long> getMatchCounts() {
		return matchCounts;
	}

	public double calculateProfitRate(int purchaseAmount) {
		long totalPrize = matchCounts.entrySet().stream()
			.mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
			.sum();

		return ((double)totalPrize / purchaseAmount) * 100;
	}
}
