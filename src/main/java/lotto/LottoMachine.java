package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
	private final List<Integer> winningNumbers;
	private final int bonusNumber;

	public LottoMachine(List<Integer> winningNumbers, int bonusNumber) {
		this.winningNumbers = winningNumbers;
		this.bonusNumber = bonusNumber;
	}

	public Result check(List<Lotto> lottos, int money) {
		Map<Prize, Integer> winningResults = initializeResultToZero();

		for (Lotto lotto : lottos) {
			int matchCount = lotto.countMatchingNumbers(winningNumbers);
			boolean hasBonus = lotto.hasBonus(bonusNumber);

			Prize prize = Prize.rank(matchCount, hasBonus);
			winningResults.put(prize, winningResults.getOrDefault(prize, 0) + 1);
		}

		double prizeRate = caculatePrizeRate(money, winningResults);

		return parseResult(winningResults, prizeRate);
	}

	private Result parseResult(Map<Prize, Integer> winningResults, double prizeRate) {
		return new Result(
				winningResults.get(Prize.FIFTH),
				winningResults.get(Prize.FOURTH),
				winningResults.get(Prize.THIRD),
				winningResults.get(Prize.SECOND),
				winningResults.get(Prize.FIRST),
				prizeRate
		);
	}

	private Map<Prize, Integer> initializeResultToZero() {
		Map<Prize, Integer> winningResults = new EnumMap<>(Prize.class);

		for (Prize prize : Prize.values()) {
			winningResults.put(prize, 0);
		}

		return winningResults;
	}

	private static double caculatePrizeRate(int money, Map<Prize, Integer> winningResults) {
		double prizeAmount = winningResults.entrySet().stream()
				.mapToDouble(entry -> (entry.getKey().getAmount()) * entry.getValue())
				.sum();

		return (prizeAmount / money) * 100;
	}
}
