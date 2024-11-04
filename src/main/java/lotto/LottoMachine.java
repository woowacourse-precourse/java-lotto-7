package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
	private static final int PERCENT_UNIT = 100;

	public Result informWinningResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber, int money) {
		Map<Prize, Integer> winningResults = new EnumMap<>(Prize.class);

		initializeResultToZero(winningResults);

		for (Lotto lotto : lottos) {
			recordWinningResult(lotto, winningNumbers, bonusNumber, winningResults);
		}

		double prizeRate = caculatePrizeRate(money, winningResults);

		return parseResult(winningResults, prizeRate);
	}

	private static void recordWinningResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber, Map<Prize, Integer> winningResults) {
		int matchCount = lotto.countMatchingNumbers(winningNumbers);
		boolean hasBonus = lotto.hasBonus(bonusNumber);

		Prize prize = Prize.rank(matchCount, hasBonus);
		winningResults.put(prize, winningResults.getOrDefault(prize, 0) + 1);
	}

	private Result parseResult(Map<Prize, Integer> winningResults, double prizeRate) {
		return new Result(
				winningResults.getOrDefault(Prize.FIFTH, 0),
				winningResults.getOrDefault(Prize.FOURTH, 0),
				winningResults.getOrDefault(Prize.THIRD, 0),
				winningResults.getOrDefault(Prize.SECOND, 0),
				winningResults.getOrDefault(Prize.FIRST, 0),
				prizeRate
		);
	}

	private static void initializeResultToZero(Map<Prize, Integer> winningResults) {
		for (Prize prize : Prize.values()) {
			winningResults.put(prize, 0);
		}
	}

	private static double caculatePrizeRate(int money, Map<Prize, Integer> winningResults) {
		double prizeAmount = winningResults.entrySet().stream()
				.mapToDouble(entry -> (entry.getKey().getAmount()) * entry.getValue())
				.sum();

		return (prizeAmount / money) * PERCENT_UNIT;
	}
}
