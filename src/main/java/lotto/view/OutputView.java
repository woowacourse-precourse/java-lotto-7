package lotto.view;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.model.domain.LottoBundle;
import lotto.model.domain.Rank;

public class OutputView {
	public static void promptPurchaseMoney() {
		System.out.println("구입금액을 입력해 주세요.");
	}

	public static void promptPurchaseCount(int lottoCount) {
		System.out.println("\n" + lottoCount + "개를 구매했습니다.");
	}

	public static void promptLottoNumbers(LottoBundle lottoBundle) {
		lottoBundle.lottoBundle().forEach(lotto -> {
			String formattedNumbers = lotto.getNumbers().stream()
				.sorted()
				.map(String::valueOf)
				.collect(Collectors.joining(", ", "[", "]"));

			System.out.println(formattedNumbers);
		});
	}

	public static void promptWinningNumber() {
		System.out.println("\n당첨 번호를 입력해 주세요.");
	}

	public static void promptBonusNumber() {
		System.out.println("\n보너스 번호를 입력해 주세요.");
	}

	public static void printWinningStatistics(Map<Rank, Integer> rankCounts) {
		System.out.println("\n당첨 통계");
		System.out.println("---");

		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);

		Arrays.stream(Rank.values())
			.forEach(rank -> {
				int count = rankCounts.getOrDefault(rank, 0);

				if (rank == Rank.SECOND) {
					System.out.printf("5개 일치, 보너스 볼 일치 (%s원) - %d개%n",
						numberFormat.format(rank.getPrize()), count);
					return;
				}

				System.out.printf("%d개 일치 (%s원) - %d개%n",
					rank.getMatchCount(), numberFormat.format(rank.getPrize()), count);
			});
	}

	public static void printReturnRate(double resultRate) {
		System.out.printf("총 수익률은 %.1f%%입니다.%n", resultRate);
	}
}
