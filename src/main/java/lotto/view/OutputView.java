package lotto.view;

import java.util.HashMap;
import java.util.List;

import lotto.model.Lotto;
import lotto.model.LottoRank;

public class OutputView {

	private static final String BUYING_NUMBER_MESSAGE = "%d개를 구매했습니다.";
	private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
	private static final String DASH_THREE = "---";
	private static final String NUMBER_FORMAT = "%d개\n";
	private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";
	private static final String ERROR_FORMAT = "[ERROR] ";

	public void printBuyingNumber(int buyingNumber) {
		System.out.println();
		System.out.printf(BUYING_NUMBER_MESSAGE, buyingNumber);
	}

	public void printLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto);
		}
		System.out.println();
	}

	public void printWinningResult(HashMap<LottoRank, Integer> winningResult) {
		System.out.println();
		System.out.println(WINNING_STATISTICS_MESSAGE);
		System.out.println(DASH_THREE);

		for (LottoRank rank : LottoRank.values()) {
			if (rank.name() == "BOOM") {
				continue;
			}
			System.out.print(rank);
			System.out.printf(NUMBER_FORMAT, winningResult.get(rank));
		}
	}

	public void printRateOfReturn(double rateOfReturn) {
		System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
	}

	public void printErrorMessage(IllegalArgumentException e) {
		System.out.println(ERROR_FORMAT + e.getMessage());
	}
}
