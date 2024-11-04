package lotto.domain;

import static lotto.domain.Prize.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMatchingMachineTest {

	@DisplayName("당첨 내역 조회 머신을 생성할 수 있다.")
	@Test
	void from() {

		// given
		List<Integer> inputWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
		int bonusNumber = 31;
		WinningNumbers winningNumbers = WinningNumbers.of(inputWinningNumbers, bonusNumber);

		// when
		LottoMatchingMachine lottoMatchingMachine = LottoMatchingMachine.from(winningNumbers);

		// then
		assertThat(lottoMatchingMachine)
			.extracting("winningNumbers")
			.isEqualTo(winningNumbers);
	}

	@DisplayName("당첨 등수를 조회할 수 있다.")
	@Test
	void matchAll() {

		// given
		List<Integer> inputWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
		int bonusNumber = 45;
		WinningNumbers winningNumbers = WinningNumbers.of(inputWinningNumbers, bonusNumber);

		LottoMatchingMachine lottoMatchingMachine = LottoMatchingMachine.from(winningNumbers);

		List<List<Integer>> lottoNumbers = List.of(
			List.of(1, 2, 3, 4, 5, 45), // 2등
			List.of(1, 2, 3, 4, 5, 11), // 3등
			List.of(1, 2, 3, 7, 8, 45), // 5등
			List.of(1, 2, 3, 10, 11, 12), // 5등
			List.of(31, 32, 33, 34, 35, 37), // nothing
			List.of(21, 22, 23, 24, 25, 27) // nothing
		);
		Lottos lottos = Lottos.from(lottoNumbers);

		// when
		Map<Prize, Integer> matchResult = lottoMatchingMachine.matchAll(lottos);

		// then
		assertThat(matchResult).containsExactly(
			entry(SECOND, 1),
			entry(THIRD, 1),
			entry(FIFTH, 2),
			entry(NOTHING, 2)
		);
	}
}