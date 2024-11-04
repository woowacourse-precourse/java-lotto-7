package lotto.view;

import static lotto.global.LottoConstant.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.GameResults;
import lotto.domain.Lotto;
import lotto.domain.enums.Rank;

public class OutputView {
	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printGameResult(GameResults gameResults) {
		printMessage("당첨 통계");
		printMessage("---");

		Map<Rank, Integer> gameResultMap = gameResults.getGameResultMap();

		for (Rank rank : Rank.values()) {
			String resultMessage = String.format(rank.getWinningMessage(), gameResultMap.getOrDefault(rank, 0));
			printMessage(resultMessage);
		}

		printMessage("총 수익률은 " + gameResults.getRoundedProfitRate() + "%입니다.");
	}

	public static void printPurchaseLotto(List<Lotto> lottos) {
		String purchaseCount = lottos.size() + "개를 구매했습니다.";
		printMessage(purchaseCount);

		for (Lotto lotto : lottos) {
			String lottoNumbers = lotto.getNumbers().stream()
				.map(String::valueOf)
				.collect(Collectors.joining(LOTTO_NUMBER_SEPARATOR));

			printMessage(lottoNumbers);
		}

	}
}
