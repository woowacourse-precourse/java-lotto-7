package lotto.view;

import static lotto.domain.enums.Rank.*;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.enums.Rank;

public class OutputView {

	private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	private static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
	private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
	private static final String PURCHASED_BY_SIZE = "%d개를 구매했습니다.%n";

	public static void printPurchaseAmountRequest() {
		System.out.println(REQUEST_PURCHASE_AMOUNT);
	}

	public static void printWinningNumbersRequest() {
		System.out.println(REQUEST_WINNING_NUMBERS);
	}

	public static void printBonusNumberRequest() {
		System.out.println(REQUEST_BONUS_NUMBER);
	}

	public static void printPurchasedLottos(List<Lotto> lottos) {
		System.out.printf(PURCHASED_BY_SIZE, lottos.size());
		lottos.forEach(System.out::println);
	}
}
