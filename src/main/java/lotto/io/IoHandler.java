package lotto.io;

import java.util.ArrayList;
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
		boolean isValidAmount = false;
		int purchaseAmount = 0;
		while (!isValidAmount) {
			outputHandler.showPurchaseAmountPrompt();
			String input = inputHandler.readLine();
			try {
				purchaseAmount = validatingParser.validatePurchaseAmount(input);
				isValidAmount = true;
			} catch (IllegalArgumentException invalidAmountException) {
				outputHandler.showExceptionMessage(invalidAmountException.getMessage());
			}
		}
		return purchaseAmount;
	}

	public void showExceptionMessage(String message) {
		outputHandler.showExceptionMessage(message);
	}

	public void showPurchaseLottos(PurchasedLottos purchasedLottos) {
		outputHandler.showPurchaseLottos(purchasedLottos.getLottosSize(), purchasedLottos.getPurchasedLottos());
	}

	public List<Integer> getWinningNumbersFromUser() {
		boolean isValidWinningNumbers = false;
		List<Integer> purchaseAmount = new ArrayList<>();
		while (!isValidWinningNumbers) {
			outputHandler.showWinningNumbersPrompt();
			String input = inputHandler.readLine();
			try {
				purchaseAmount = validatingParser.validateWinningNumbers(input);
				isValidWinningNumbers = true;
			} catch (IllegalArgumentException invalidWinningNumbersException) {
				outputHandler.showExceptionMessage(invalidWinningNumbersException.getMessage());
			}
		}
		return purchaseAmount;
	}

	public int getBonusNumberFromUser() {
		boolean isValidBonusNumber = false;
		int bonusNumber = 0;
		while (!isValidBonusNumber) {
			outputHandler.showBonusNumberPrompt();
			String input = inputHandler.readLine();
			try {
				bonusNumber = validatingParser.validateBonusNumber(input);
				isValidBonusNumber = true;
			} catch (IllegalArgumentException invalidBonusNumberException) {
				outputHandler.showExceptionMessage(invalidBonusNumberException.getMessage());
			}
		}
		return bonusNumber;
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
