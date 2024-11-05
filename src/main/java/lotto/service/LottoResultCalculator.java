package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.WinningNumber;

public class LottoResultCalculator {

	public Map<Prize, Integer> calculateResults(List<Lotto> lottos, WinningNumber winningNumber) {
		Map<Prize, Integer> prizeCountMap = initializePrizeCount();

		for (Lotto lotto : lottos) {
			int matchCount = getMatchCount(lotto.getNumbers(), winningNumber.getWinningNumbers());
			boolean hasBonus = lotto.getNumbers().contains(winningNumber.getBonusNumber());
			Prize prize = Prize.findPrize(matchCount, hasBonus);
			prizeCountMap.put(prize, prizeCountMap.get(prize) + 1);
		}

		return prizeCountMap;
	}

	private Map<Prize, Integer> initializePrizeCount() {
		Map<Prize, Integer> prizeCountMap = new HashMap<>();
		for (Prize prize : Prize.values()) {
			prizeCountMap.put(prize, 0);
		}
		return prizeCountMap;
	}

	private int getMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
		return (int)lottoNumbers.stream()
			.filter(winningNumbers::contains)
			.count();
	}
}
