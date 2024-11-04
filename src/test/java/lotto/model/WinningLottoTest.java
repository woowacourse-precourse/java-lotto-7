package lotto.model;

import static lotto.model.Winning.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class WinningLottoTest {

	@ParameterizedTest
	@DisplayName("등수에 맞게 추첨할 수 있다.")
	@EnumSource(value = Winning.class, names = {"FIRST", "SECOND", "THIRD", "FOURTH", "FIFTH"})
	void 등수에_맞게_추첨한다(Winning winning) {
		// given
		LottoCreator lottoCreator = new LottoCreator();
		LottoBundle lottoBundle = new LottoBundle(new Price(1000), lottoCreator);
		List<Integer> lottoNumbers = lottoBundle.getLottos().getFirst().getNumbers().stream()
				.map(LottoNumber::getNumber)
				.toList();
		WinningLotto winningLotto = createWinningLotto(lottoNumbers, winning, lottoCreator);

		// when
		Map<Winning, Integer> winningResult = winningLotto.drawLottoBundle(lottoBundle);

		// then
		assertEquals(1, winningResult.get(winning));
	}

	private WinningLotto createWinningLotto(List<Integer> lottoNumbers, Winning winning, LottoCreator lottoCreator) {
		List<Integer> winningNumbers = createWinningNumbers(lottoNumbers, winning);
		int bonusNumber = createBonusNumber(winningNumbers, lottoNumbers, winning);
		return new WinningLotto(winningNumbers, bonusNumber, lottoCreator);
	}

	private List<Integer> createWinningNumbers(List<Integer> lottoNumbers, Winning winning) {
		int count = winning.getCount();
		List<Integer> winningNumbers = lottoNumbers.stream()
				.limit(count)
				.collect(Collectors.toList());
		winningNumbers.addAll(getInvalidWinningNumbers(lottoNumbers, 6 - count));
		return winningNumbers;
	}

	private List<Integer> getInvalidWinningNumbers(List<Integer> lottoNumbers, int count) {
		return IntStream.rangeClosed(1, 45)
				.filter(i -> !lottoNumbers.contains(i))
				.limit(count)
				.boxed()
				.toList();
	}

	private int createBonusNumber(List<Integer> winningNumbers, List<Integer> lottoNumbers, Winning winning) {
		if (winning == SECOND) {
			return getValidBonusNumber(winningNumbers, lottoNumbers);
		}
		return getInvalidBonusNumber(winningNumbers, lottoNumbers);
	}

	private int getValidBonusNumber(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
		return lottoNumbers.stream()
				.filter(lottoNumber -> !winningNumbers.contains(lottoNumber))
				.findFirst()
				.get();
	}

	private int getInvalidBonusNumber(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
		return IntStream.rangeClosed(1, 45)
				.filter(number -> !winningNumbers.contains(number) && !lottoNumbers.contains(number))
				.findFirst()
				.getAsInt();
	}
}