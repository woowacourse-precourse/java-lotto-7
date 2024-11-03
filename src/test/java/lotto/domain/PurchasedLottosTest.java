package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PurchasedLottosTest {
	@DisplayName("당첨번호를 받아 구매한 로또 목록과 비교하여 당첨 등수 목록을 반환한다.")
	@MethodSource("compareWinningNumbersProvider")
	@ParameterizedTest(name = "{0}")
	void compareWinningNumbers(String description, List<Integer> inputMainWinningNumbers, int inputBonusNumber,
		List<Lotto> inputLottos, List<Rank> expectedRanks) {
		//given
		MainWinningNumbers mainWinningNumbers = MainWinningNumbers.from(inputMainWinningNumbers);
		BonusNumber bonusNumber = BonusNumber.from(inputBonusNumber);
		WinningNumbers winningNumbers = WinningNumbers.of(mainWinningNumbers, bonusNumber);
		PurchasedLottos purchasedLottos = PurchasedLottos.from(inputLottos);

		//when
		List<Rank> result = purchasedLottos.compareWinningNumbers(winningNumbers);

		//then
		assertThat(expectedRanks).isEqualTo(result);
	}

	static Stream<Arguments> compareWinningNumbersProvider() {
		return Stream.of(
			Arguments.of(
				"구매 번호중 1등 당첨이 1개 있다면 1등을 반환한다.",
				List.of(1, 2, 3, 4, 5, 6), 7,
				provideLottosWithFirstPrize(),
				List.of(Rank.FIRST)
			),
			Arguments.of(
				"구매 번호중 5등 당첨이 1개, 4등 당첨이 1개 있다면 해당 등수들을 반환한다.",
				List.of(1, 2, 3, 11, 12, 13), 7,
				provideLottosWithForthAndFifthPrizes(),
				List.of(Rank.FIFTH, Rank.FORTH)
			),
			Arguments.of(
				"구매 번호중 일치하는 번호가 없다면 빈 리스트를 반환한다.",
				List.of(21, 22, 23, 24, 25, 26), 7,
				provideUnmatchedLottos(),
				List.of()
			)
		);
	}

	static List<Lotto> provideLottosWithFirstPrize() {
		return List.of(
			new Lotto(List.of(1, 2, 3, 4, 5, 6)),
			new Lotto(List.of(30, 31, 32, 34, 35, 36)),
			new Lotto(List.of(37, 38, 39, 40, 41, 42))
		);
	}

	static List<Lotto> provideLottosWithForthAndFifthPrizes() {
		return List.of(
			new Lotto(List.of(1, 2, 3, 4, 5, 6)),
			new Lotto(List.of(30, 31, 32, 34, 35, 36)),
			new Lotto(List.of(1, 2, 3, 11, 21, 31))
		);
	}

	static List<Lotto> provideUnmatchedLottos() {
		return List.of(new Lotto(List.of(11, 12, 13, 14, 15, 16)),
			new Lotto(List.of(30, 31, 32, 34, 35, 36)),
			new Lotto(List.of(37, 38, 39, 40, 41, 45))
		);
	}
}
