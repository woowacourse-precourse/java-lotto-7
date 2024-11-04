package lotto.view;

import java.util.Map;
import lotto.domain.enums.Rank;

public class OutputView {

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printGameResult(Map<Rank, Integer> lottoRankMap, double roundedProfitRate) {
		System.out.println("당첨 통계");
		System.out.println("---");

		for (Rank rank : Rank.values()) {
			String resultMessage = String.format(rank.getWinningMessage(), lottoRankMap.getOrDefault(rank, 0));
			System.out.println(resultMessage);
		}

		System.out.println("총 수익률은 " + roundedProfitRate + "%입니다.");
	}
}
