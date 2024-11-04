package lotto.io.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.io.output.PurchasePrintHandler;
import lotto.io.request.BudgetRequest;
import lotto.io.request.LottoRequest;
import lotto.io.request.bonusNumberRequest;

public class InputHandler {

    PurchasePrintHandler purchasePrintHandler = new PurchasePrintHandler();

    public BudgetRequest getBudgets() {
        while (true) {
            try {
                purchasePrintHandler.printPurchaseMessage();
                String budgets = Console.readLine();
                return new BudgetRequest(budgets);
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

    public bonusNumberRequest getBonusNumber(Lotto lotto) {
        while (true) {
            try {
                purchasePrintHandler.printBonusNumbers();
                String bonusNumber = Console.readLine();
                return new bonusNumberRequest(lotto, bonusNumber);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
