package lotto.view;

import static lotto.model.domain.OutputMessage.*;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.model.domain.Delimiter;
import lotto.model.domain.LottoBundle;
import lotto.model.domain.Rank;

public class OutputView {
	public static void promptPurchaseMoney() {
		System.out.println(PROMPT_PURCHASE_MONEY.getMessage());
	}

	public static void promptPurchaseCount(int lottoCount) {
		System.out.printf((PROMPT_PURCHASE_COUNT.getMessage()) + NEW_LINE, lottoCount);
	}

	public static void promptLottoNumbers(LottoBundle lottoBundle) {
		lottoBundle.lottoBundle().forEach(lotto -> {
			String formattedNumbers = lotto.getNumbers().stream()
				.sorted()
				.map(String::valueOf)
				.collect(Collectors.joining(Delimiter.COMMA.getDelimiter() + " "));

			System.out.printf((LOTTO_NUMBERS_FORMAT.getMessage()) + NEW_LINE, formattedNumbers);
		});
	}

	public static void promptWinningNumber() {
		System.out.println(PROMPT_WINNING_NUMBER.getMessage());
	}

	public static void promptBonusNumber() {
		System.out.println(PROMPT_BONUS_NUMBER.getMessage());
	}

	public static void promptWinningStatistics(Map<Rank, Integer> rankCounts) {
		System.out.println(WINNING_STATISTICS.getMessage());
		System.out.println(WINNING_STATISTICS_DIVIDER.getMessage());

		promptRankCounts(rankCounts);
	}

	private static void promptRankCounts(Map<Rank, Integer> rankCounts) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

		Arrays.stream(Rank.values())
			.forEach(rank -> promptRankStatistics(rank, rankCounts, numberFormat));
	}

	private static void promptRankStatistics(Rank rank, Map<Rank, Integer> rankCounts, NumberFormat numberFormat) {
		int count = rankCounts.getOrDefault(rank, 0);

		if (rank == Rank.SECOND) {
			System.out.printf(WINNING_STATISTICS_FORMAT.getMessage(),
				numberFormat.format(rank.getPrize()), count);
			return;
		}

		System.out.printf(MATCH_COUNT_FORMAT.getMessage(),
			rank.getMatchCount(), numberFormat.format(rank.getPrize()), count);
	}

	public static void promptReturnRate(double resultRate) {
		System.out.printf(RETURN_RATE.getMessage(), resultRate);
	}

	public static void promptErrorMessage(IllegalArgumentException e) {
		System.out.println(e.getMessage());
	}
}
