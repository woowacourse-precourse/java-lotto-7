package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {
	@DisplayName("구매 총액, 구매한 로또, 당첨 번호를 받아 당첨 결과를 생성한다.")
	@MethodSource("lottoReportProvider")
	@ParameterizedTest(name = "{0}")
	void of(String description, int inputAmount, List<Integer> inputMainWinningNumbers, int inputBonusNumber,
		List<Lotto> inputLottos) {
		//given
		Amount amount = Amount.of(inputAmount);
		MainWinningNumbers mainWinningNumbers = MainWinningNumbers.from(inputMainWinningNumbers);
		BonusNumber bonusNumber = BonusNumber.from(inputBonusNumber);
		WinningNumbers winningNumbers = WinningNumbers.of(mainWinningNumbers, bonusNumber);
		PurchasedLottos purchasedLottos = PurchasedLottos.from(inputLottos);

		//when
		LottoResult result = LottoResult.of(amount, purchasedLottos, winningNumbers);

		//then
		assertThat(result).isNotNull();
	}

	@DisplayName("당첨 번호와 구매한 로또를 비교하여 각 등수별 당첨 횟수를 반환한다.")
	@MethodSource("lottoReportProvider")
	@ParameterizedTest(name = "{0}")
	void ofWithRankCount(String description, int inputAmount, List<Integer> inputMainWinningNumbers,
		int inputBonusNumber,
		List<Lotto> inputLottos, Map<Rank, Integer> expectRankCount) {
		//given
		Amount amount = Amount.of(inputAmount);
		MainWinningNumbers mainWinningNumbers = MainWinningNumbers.from(inputMainWinningNumbers);
		BonusNumber bonusNumber = BonusNumber.from(inputBonusNumber);
		WinningNumbers winningNumbers = WinningNumbers.of(mainWinningNumbers, bonusNumber);
		PurchasedLottos purchasedLottos = PurchasedLottos.from(inputLottos);

		//when
		LottoResult result = LottoResult.of(amount, purchasedLottos, winningNumbers);

		//then
		assertThat(result).extracting("rankCount").isEqualTo(expectRankCount);
	}

	@DisplayName("구매 금액 대비 당첨 금액으로 수익률을 계산한다.")
	@MethodSource("profitRateProvider")
	@ParameterizedTest(name = "{0}")
	void ofWithProfitRate(String description, int inputAmount, List<Integer> inputMainWinningNumbers,
		int inputBonusNumber,
		List<Lotto> inputLottos, String expectProfitRate) {
		//given
		Amount amount = Amount.of(inputAmount);
		MainWinningNumbers mainWinningNumbers = MainWinningNumbers.from(inputMainWinningNumbers);
		BonusNumber bonusNumber = BonusNumber.from(inputBonusNumber);
		WinningNumbers winningNumbers = WinningNumbers.of(mainWinningNumbers, bonusNumber);
		PurchasedLottos purchasedLottos = PurchasedLottos.from(inputLottos);

		//when
		LottoResult result = LottoResult.of(amount, purchasedLottos, winningNumbers);

		//then
		assertThat(result).extracting("profitRate").isEqualTo(expectProfitRate);
	}

	static Stream<Arguments> lottoReportProvider() {
		return Stream.of(
			Arguments.of(
				"전체 당첨 목록에서 1등의 카운트를 1을 증가하여 반환한다.",
				3000,
				List.of(1, 2, 3, 4, 5, 6), 7,
				provideLottosWithFirstPrize(),
				Map.of(Rank.FIRST, 1, Rank.SECOND, 0, Rank.THIRD, 0, Rank.FORTH, 0, Rank.FIFTH, 0)
			),
			Arguments.of(
				"전체 당첨 목록에서 5등 카운트를 1, 4등 당첨의 카운트를 1 증가하여 반환한다.",
				3000,
				List.of(1, 2, 3, 11, 12, 13), 7,
				provideLottosWithForthAndFifthPrizes(),
				Map.of(Rank.FIRST, 0, Rank.SECOND, 0, Rank.THIRD, 0, Rank.FORTH, 1, Rank.FIFTH, 1)
			),
			Arguments.of(
				"전체 당첨 목록에서 당첨된것이 없다면 모든 카운트를 0으로 반환한다.",
				3000,
				List.of(21, 22, 23, 24, 25, 26), 7,
				provideUnmatchedLottos(),
				Map.of(Rank.FIRST, 0, Rank.SECOND, 0, Rank.THIRD, 0, Rank.FORTH, 0, Rank.FIFTH, 0)
			)
		);
	}

	static Stream<Arguments> profitRateProvider() {
		return Stream.of(
			Arguments.of(
				"구매 금액 3000원, 1등 1회 당첨시 수익률은 66666666.7%이다.",
				3000,
				List.of(1, 2, 3, 4, 5, 6), 7,
				provideLottosWithFirstPrize(),
				"66666666.7"
			),
			Arguments.of(
				"구매 금액 3000원, 4등 1회와 5등 1회 당첨시 수익률은 1833.3%이다.",
				3000,
				List.of(1, 2, 3, 11, 12, 13), 7,
				provideLottosWithForthAndFifthPrizes(),
				"1833.3"
			),
			Arguments.of(
				"구매 금액 1,000,000원, 5등 1회 당첨시 수익률은 0.5%이다.",
				1000000,
				List.of(11, 12, 13, 24, 25, 26), 7,
				provideUnmatchedLottos(),
				"0.5"
			),
			Arguments.of(
				"구매 금액 3000원, 미당첨시 수익률은 0.0%이다.",
				3000,
				List.of(21, 22, 23, 24, 25, 26), 7,
				provideUnmatchedLottos(),
				"0.0"
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
