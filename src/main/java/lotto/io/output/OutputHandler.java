package lotto.io.output;

import static lotto.domain.Prize.*;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;

public class OutputHandler {

	private static final String LOTTO_SIGN_DELIMITER = ", ";
	private static final String LOTTO_SIGN_PREFIX = "[";
	private static final String LOTTO_SIGN_SUFFIX = "]";
	private static final String PURCHASE_AMOUNT_INPUT_COMMENT = "구입금액을 입력해 주세요.";
	private static final String PURCHASED_LOTTO_COUNT_COMMENT = "개를 구매했습니다.";
	private static final String WINNING_NUMBERS_INPUT_COMMENT = "당첨 번호를 입력해 주세요.";
	private static final String BONUS_NUMBERS_INPUT_COMMENT = "보너스 번호를 입력해 주세요.";
	private static final String WINNING_STATISTICS_COMMENT = "당첨 통계";
	private static final String WINNING_STATISTICS_LINE_CHANGE_SIGN = "---";
	private static final String PRIZE_WITHOUT_BONUS_COMMENT_FORMAT = "%d개 일치 (%,d원) - %d개\n";
	private static final String PRIZE_WITH_BONUS_COMMENT_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
	private static final String YIELD_FORMAT = "총 수익률은 %.1f%%입니다.\n";

	public void showPurchaseAmountInputComment() {
		System.out.println(PURCHASE_AMOUNT_INPUT_COMMENT);
	}

	public void showPurchasedLottos(Lottos lottos) {
		List<Lotto> lottosToShow = lottos.getLottos();
		System.out.println(lottosToShow.size() + PURCHASED_LOTTO_COUNT_COMMENT);

		for (Lotto lotto : lottosToShow) {
			String lottoSign = makeLottoSign(lotto);
			System.out.println(lottoSign);
		}
	}

	private String makeLottoSign(Lotto lotto) {
		StringJoiner stringJoiner = new StringJoiner(LOTTO_SIGN_DELIMITER, LOTTO_SIGN_PREFIX, LOTTO_SIGN_SUFFIX);

		List<Integer> lottoNumbers = lotto.getNumbers();

		for (Integer lottoNumber : lottoNumbers) {
			stringJoiner.add(String.valueOf(lottoNumber));
		}

		return stringJoiner.toString();
	}

	public void showWinningNumbersInputComment() {
		System.out.println();
		System.out.println(WINNING_NUMBERS_INPUT_COMMENT);
	}

	public void showBonusNumberInputComment() {
		System.out.println();
		System.out.println(BONUS_NUMBERS_INPUT_COMMENT);
	}

	public void showMatchingResult(Map<Prize, Integer> matchResult, double prizeYield) {
		System.out.println(WINNING_STATISTICS_COMMENT);
		System.out.println(WINNING_STATISTICS_LINE_CHANGE_SIGN);

		showAllPrize(matchResult);

		showYieldAsPercentage(prizeYield);
	}

	private void showYieldAsPercentage(double prizeYield) {
		System.out.printf(YIELD_FORMAT, prizeYield);
	}

	private void showAllPrize(Map<Prize, Integer> matchResult) {
		showPrize(FIFTH, matchResult.getOrDefault(FIFTH, 0));
		showPrize(FOURTH, matchResult.getOrDefault(FOURTH, 0));
		showPrize(THIRD, matchResult.getOrDefault(THIRD, 0));
		showPrize(SECOND, matchResult.getOrDefault(SECOND, 0));
		showPrize(FIRST, matchResult.getOrDefault(FIRST, 0));
	}

	private void showPrize(Prize prize, int count) {
		if (prize.isBonusRequired()) {
			System.out.printf(PRIZE_WITH_BONUS_COMMENT_FORMAT,
				prize.getWinningNumberHitCount(),
				prize.getPrizeMoney(),
				count);
			return;
		}

		System.out.printf(PRIZE_WITHOUT_BONUS_COMMENT_FORMAT,
			prize.getWinningNumberHitCount(),
			prize.getPrizeMoney(),
			count);
	}

}
