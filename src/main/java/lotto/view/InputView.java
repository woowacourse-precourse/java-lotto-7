package lotto.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.lottoticketexception.DuplicateException;
import lotto.exception.lottoticketexception.LottoNumberSizeException;
import lotto.exception.numberexception.InvalidNumberException;
import lotto.exception.numberexception.OutOfRangeNumberException;
import lotto.exception.purchaseamountexception.InvalidPurchaseAmountException;
import lotto.exception.purchaseamountexception.MaxPurchaseExceedException;
import lotto.exception.purchaseamountexception.NegativePurchaseAmountException;
import lotto.exception.purchaseamountexception.NotDivisibleByLottoPriceException;
import lotto.util.PurchaseAmountValidator;
import lotto.util.WinningNumberSeparator;

public class InputView {

	private final OutputView outputView;
	private final PurchaseAmountValidator purchaseAmountValidator;
	private final WinningNumberSeparator winningNumberSeparator;

	public InputView(OutputView outputView, PurchaseAmountValidator purchaseAmountValidator,
		WinningNumberSeparator winningNumberSeparator) {
		this.outputView = outputView;
		this.purchaseAmountValidator = purchaseAmountValidator;
		this.winningNumberSeparator = winningNumberSeparator;
	}

	public String readLine() {
		return Console.readLine();
	}

	public int getPurchaseAmount() {
		while (true) {
			outputView.printPurchaseAmountMessage();
			String input = readLine();

			try {
				return purchaseAmountValidator.validateInput(input);
			} catch (InvalidPurchaseAmountException e) {
				outputView.printInvalidPurchaseAmountMessage();
			} catch (NegativePurchaseAmountException e) {
				outputView.printInvalidPurchaseAmountMessage();
			} catch (NotDivisibleByLottoPriceException e) {
				outputView.printNotDivisibleByLottoPriceMessage();
			} catch (MaxPurchaseExceedException e) {
				outputView.printMaxPurchaseExceedMessage();
			}
		}
	}

	public List<Integer> getWinningNumbers() {
		while (true) {
			outputView.printToGetWinningNumbers();
			String input = readLine();

			try {
				return winningNumberSeparator.splitByComma(input);
			} catch (LottoNumberSizeException e) {
				outputView.printInvalidLottoNumberSizeMessage();
			} catch (OutOfRangeNumberException e) {
				outputView.printOutOfRangeNumberMessage();
			} catch (DuplicateException e) {
				outputView.printDuplicateNumberMessage();
			}
		}
	}

	public int getBonusNumber() {
		while (true) {
			outputView.printToGetBonusNumbers();
			String input = readLine();

			try {
				return Integer.parseInt(input);
			} catch (InvalidNumberException e) {
				outputView.printOutOfRangeNumberMessage();
			} catch (OutOfRangeNumberException e) {
				outputView.printOutOfRangeNumberMessage();
			} catch (DuplicateException e) {
				outputView.printDuplicateNumberMessage();
			}
		}
	}
}
