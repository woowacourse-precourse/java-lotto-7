package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoMatchingMachine {

	private final WinningNumbers winningNumbers;

	private LottoMatchingMachine(WinningNumbers winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	public static LottoMatchingMachine from(WinningNumbers winningNumbers) {
		return new LottoMatchingMachine(winningNumbers);
	}

	public Map<Prize, Integer> matchAll(Lottos lottos) {
		Map<Prize, Integer> matchResult = new EnumMap<>(Prize.class);

		List<Lotto> candidateLottos = lottos.getLottos();
		candidateLottos.stream()
			.map(this::match)
			.forEach(eachMatchResult ->
				matchResult.put(eachMatchResult, matchResult.getOrDefault(eachMatchResult, 0) + 1));

		return matchResult;
	}

	private Prize match(Lotto lotto) {
		List<Integer> lottoNumbers = lotto.getNumbers();

		int hitCount = (int)lottoNumbers.stream()
			.filter(winningNumbers::doesWinningNumbersContains)
			.count();

		boolean isBonusHit = winningNumbers.isBonusNumberContainedIn(lottoNumbers);

		return Prize.valueOfWinningNumberHitCountAndBonusHit(hitCount, isBonusHit);
	}

}
