package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.io.request.LottoRequest;
import lotto.io.request.NumberRequest;

public class InputHandler {

    PurchasePrintHandler purchasePrintHandler = new PurchasePrintHandler();

    public NumberRequest getBudgets() {
        while (true) {
            try {
                purchasePrintHandler.printPurchaseMessage();
                String budgets = Console.readLine();
                return new NumberRequest(budgets);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public LottoRequest getWinningNumbers() {
        while (true) {
            try {
                purchasePrintHandler.printWinningNumbers();
                String winningNumbers = Console.readLine();
                return new LottoRequest(winningNumbers);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public NumberRequest getBonusNumber() {
        while (true) {
            try {
                purchasePrintHandler.printBonusNumbers();
                String bonusNumber = Console.readLine();
                return new NumberRequest(bonusNumber);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
