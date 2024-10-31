package lotto.io;

import java.util.List;

import lotto.domain.Lotto;

public class OutputHandler {

	private final static String PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	private final static String PROMPT_PURCHASE_COUNT_SUFFIX = "개를 구매했습니다.";
	private final static String PROMPT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
	private final static String PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
	private final static String PROMPT_WINNING_REPORT_HEADER = "당첨 통계 \n ---";

	private OutputHandler() {
	}

	private static class Holder {
		private static final OutputHandler INSTANCE = new OutputHandler();
	}

	public static OutputHandler getInstance() {
		return Holder.INSTANCE;
	}

	public void showPurchaseAmountPrompt() {
		System.out.println(PROMPT_PURCHASE_AMOUNT);
	}

	public void showPurchaseLottos(int lottoSize, List<Lotto> lottos) {
		System.out.println(lottoSize + PROMPT_PURCHASE_COUNT_SUFFIX);
		lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
	}

	public void showWinningNumbersPrompt() {
		System.out.println(PROMPT_WINNING_NUMBERS);
	}

	public void showBonusNumberPrompt() {
		System.out.println(PROMPT_BONUS_NUMBER);
	}

	public void showWinningReport() {
		System.out.println(PROMPT_WINNING_REPORT_HEADER);
	}

	public void showExceptionMessage(String message) {
		System.out.println(message);
	}
}
