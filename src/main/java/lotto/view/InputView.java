package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidPurchaseAmountException;
import lotto.exception.MaxPurchaseExceedException;
import lotto.exception.NegativePurchaseAmountException;
import lotto.exception.NotDivisibleByLottoPriceException;
import lotto.util.PurchaseAmountValidator;

public class InputView {

	private final OutputView outputView;
	private final PurchaseAmountValidator purchaseAmountValidator;

	public InputView(OutputView outputView, PurchaseAmountValidator purchaseAmountValidator) {
		this.outputView = outputView;
		this.purchaseAmountValidator = purchaseAmountValidator;
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
}
