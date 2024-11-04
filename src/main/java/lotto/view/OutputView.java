package lotto.view;

import java.util.Map;

import lotto.domain.GameResults;
import lotto.domain.enums.Rank;

public class OutputView {

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printGameResult(GameResults gameResults) {
		System.out.println("당첨 통계");
		System.out.println("---");

		Map<Rank, Integer> gameResultMap = gameResults.getGameResultMap();

		for (Rank rank : Rank.values()) {
			String resultMessage = String.format(rank.getWinningMessage(), gameResultMap.getOrDefault(rank, 0));
			System.out.println(resultMessage);
		}

		System.out.println("총 수익률은 " + gameResults.getRoundedProfitRate() + "%입니다.");
	}
}
