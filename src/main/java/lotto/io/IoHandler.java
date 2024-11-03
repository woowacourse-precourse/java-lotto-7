package lotto.io;

import java.util.List;
import java.util.Map;

import lotto.domain.LottoResult;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;
import lotto.validator.ValidatingParser;

public class IoHandler {

	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private final ValidatingParser validatingParser;

	private IoHandler() {
		this.inputHandler = InputHandler.getInstance();
		this.outputHandler = OutputHandler.getInstance();
		this.validatingParser = ValidatingParser.getInstance();
	}

	private static class Holder {
		private static final IoHandler INSTANCE = new IoHandler();
	}

	public static IoHandler getInstance() {
		return Holder.INSTANCE;
	}

	public int getPurchaseAmountFromUser() {
		while (true) {
			outputHandler.showPurchaseAmountPrompt();
			String input = inputHandler.readLine();
			try {
				return validatingParser.validatePurchaseAmount(input);
			} catch (IllegalArgumentException invalidAmountException) {
				outputHandler.showExceptionMessage(invalidAmountException.getMessage());
			}
		}
	}

	public void showExceptionMessage(String message) {
		outputHandler.showExceptionMessage(message);
	}

	public void showPurchaseLottos(PurchasedLottos purchasedLottos) {
		outputHandler.showPurchaseLottos(purchasedLottos.getLottosSize(), purchasedLottos.getPurchasedLottos());
	}

	public List<Integer> getWinningNumbersFromUser() {
		while (true) {
			outputHandler.showWinningNumbersPrompt();
			String input = inputHandler.readLine();
			try {
				return validatingParser.validateWinningNumbers(input);
			} catch (IllegalArgumentException invalidWinningNumbersException) {
				outputHandler.showExceptionMessage(invalidWinningNumbersException.getMessage());
			}
		}
	}

	public int getBonusNumberFromUser() {
		while (true) {
			outputHandler.showBonusNumberPrompt();
			String input = inputHandler.readLine();
			try {
				return validatingParser.validateBonusNumber(input);
			} catch (IllegalArgumentException invalidBonusNumberException) {
				outputHandler.showExceptionMessage(invalidBonusNumberException.getMessage());
			}
		}
	}

	public void showLottoResult(LottoResult lottoResult) {
		Map<Rank, Integer> rankCount = lottoResult.getRankCount();
		String profitRate = lottoResult.getProfitRate();
		outputHandler.showWinningReportHeader();
		rankCount.forEach(
			(key, value) -> outputHandler.showWinningReportBody(key.getMessage(), value));
		outputHandler.showWinningReportProfitRate(profitRate);
	}
}
