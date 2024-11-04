package lotto.controller.service;

import lotto.domain.Lottos;
import lotto.io.input.InputHandler;
import lotto.io.output.PurchasePrintHandler;
import lotto.io.request.BudgetRequest;

public class LottoCreationService {

    private final InputHandler inputHandler;
    private final PurchasePrintHandler purchasePrintHandler;

    public LottoCreationService() {
        this.inputHandler = new InputHandler();
        this.purchasePrintHandler = new PurchasePrintHandler();
    }

    public Lottos createLottos() {
        BudgetRequest request = inputHandler.getBudgets();
        return generateLottos(request);
    }

    private Lottos generateLottos(BudgetRequest request) {
        int budgets = Integer.parseInt(request.budget());
        Lottos lottos = Lottos.from(budgets);
        purchasePrintHandler.printPurchaseAmounts(lottos.getAmounts());
        purchasePrintHandler.printPurchaseResult(lottos.getPurchaseLotto());
        return lottos;
    }
}
