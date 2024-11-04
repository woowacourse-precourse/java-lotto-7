package lotto.service;

import java.util.LinkedHashMap;
import java.util.Map;

import lotto.domains.lotto.type.LottoPrize;

public class LottoResultFactory {

	public Map<LottoPrize, Integer> generateLottoResult() {
		Map<LottoPrize, Integer> initialPrizeMap = new LinkedHashMap<>();

		for (LottoPrize prize : LottoPrize.values()) {
			initialPrizeMap.put(prize, 0);
		}

		return initialPrizeMap;
	}
}
