package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
	private final Map<Prize, Integer> prizeCountMap;

	public LottoResult() {
		prizeCountMap = new EnumMap<>(Prize.class);
		for (Prize prize : Prize.values()) {
			prizeCountMap.put(prize, 0);
		}
	}

	public void addPrize(Prize prize) {
		prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
	}

	public int getPrizeCount(Prize prize) {
		return prizeCountMap.get(prize);
	}

	public Map<Prize, Integer> getPrizeCountMap() {
		return prizeCountMap;
	}
}
