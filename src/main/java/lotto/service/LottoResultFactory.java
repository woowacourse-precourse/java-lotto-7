package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.domains.lotto.type.LottoPrize;

public class LottoResultFactory {

	public Map<LottoPrize, Integer> generateLottoResult() {
		Map<LottoPrize, Integer> initialPrizeMap = new HashMap<>();

		// 모든 LottoPrize 열거형에 대해 초기값 0을 설정
		for (LottoPrize prize : LottoPrize.values()) {
			initialPrizeMap.put(prize, 0);
		}

		return initialPrizeMap;
	}
}
