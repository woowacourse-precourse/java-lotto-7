package lotto.view;

import static lotto.domain.enums.Prize.*;

import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.enums.Prize;

public class OutputView {

	private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	private static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
	private static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
	private static final String PURCHASED_BY_SIZE = "%d개를 구매했습니다.%n";
	private static final String WINNING_STATISTICS = "당첨 통계";
	private static final String LINE = "---";
	private static final String TOTAL_PRIZE = "총 수익률은 %.1f%%입니다.%n";
	private static final String MATCH_COUNTS_THREE = "3개 일치 (5,000원) - %d개%n";
	private static final String MATCH_COUNTS_FOUR = "4개 일치 (50,000원) - %d개%n";
	private static final String MATCH_COUNTS_FIVE = "5개 일치 (1,500,000원) - %d개%n";
	private static final String MATCH_COUNTS_FIVE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n";
	private static final String MATCH_COUNTS_SIX = "6개 일치 (2,000,000,000원) - %d개%n";

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

	public static void printResult(LottoResult result, int purchaseAmount) {
		System.out.println(WINNING_STATISTICS);
		System.out.println(LINE);
		printStatistics(result.getMatchCounts());
		System.out.printf(TOTAL_PRIZE, result.calculateProfitRate(purchaseAmount));
	}

	private static void printStatistics(Map<Prize, Long> matchCounts) {
		System.out.printf(MATCH_COUNTS_THREE, getMatchCountOrZero(matchCounts, FIFTH));
		System.out.printf(MATCH_COUNTS_FOUR, getMatchCountOrZero(matchCounts, FOURTH));
		System.out.printf(MATCH_COUNTS_FIVE, getMatchCountOrZero(matchCounts, THIRD));
		System.out.printf(MATCH_COUNTS_FIVE_BONUS, getMatchCountOrZero(matchCounts, SECOND));
		System.out.printf(MATCH_COUNTS_SIX, getMatchCountOrZero(matchCounts, FIRST));
	}

	private static long getMatchCountOrZero(Map<Prize, Long> matchCounts, Prize prize) {
		return matchCounts.getOrDefault(prize, 0L);
	}
}
