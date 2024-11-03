package view.console;

import camp.nextstep.edu.missionutils.Console;
import dto.PurchaseAmountRequest;
import view.InputView;

public class ConsoleReader implements InputView {

    @Override
    public PurchaseAmountRequest readPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        return new PurchaseAmountRequest(purchaseAmount.trim());
    }
}
