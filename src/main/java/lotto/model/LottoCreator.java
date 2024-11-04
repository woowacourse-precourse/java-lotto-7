package lotto.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoCreator {

	private static final int MIN_LOTTO_NUMBER = 1;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int LOTTO_NUMBER_COUNT = 6;

	public Lotto createPurchasedLotto() {
		List<Integer> randomNumbers = getRandomNumbers();
		List<LottoNumber> lottoNumbers = getLottoNumbers(randomNumbers);
		return new Lotto(lottoNumbers);
	}

	public Lotto createWinningLotto(List<Integer> winningNumbers) {
		List<LottoNumber> lottoNumbers = getLottoNumbers(winningNumbers);
		return new Lotto(lottoNumbers);
	}

	private List<Integer> getRandomNumbers() {
		return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT);
	}

	private List<LottoNumber> getLottoNumbers(List<Integer> numbers) {
		return numbers.stream()
				.map(LottoNumber::from)
				.toList();
	}
}
