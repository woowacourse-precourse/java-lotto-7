package lotto;

import lotto.dto.PurchaseAmountDto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printPurchaseAmountMessage();

        InputView inputView = new InputView();
        PurchaseAmountDto purchaseAmountDto = inputView.readPurchaseAmount();

        System.out.println(purchaseAmountDto.amount());
    }
}
