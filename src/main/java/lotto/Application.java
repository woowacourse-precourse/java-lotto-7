package lotto;

import lotto.domain.PurchaseAmount;
import lotto.dto.PurchaseAmountDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printPurchaseAmountMessage();

        InputView inputView = new InputView();

        PurchaseAmountDto purchaseAmountDto = inputView.readPurchaseAmount();

        PurchaseAmount purchaseAmount = PurchaseAmount.from(purchaseAmountDto.amount());

        System.out.println("구매 금액: " + purchaseAmount.amount());
    }
}
