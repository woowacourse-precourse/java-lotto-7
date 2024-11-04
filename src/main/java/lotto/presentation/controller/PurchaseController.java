package lotto.presentation.controller;

import static lotto.presentation.view.InputForm.Header.PAY_AMOUNT;

import lotto.domain.LottoPurchase;
import lotto.presentation.controller.common.LottoController;
import lotto.presentation.model.Key;
import lotto.presentation.model.Model;
import lotto.presentation.view.InputForm;
import lotto.presentation.view.OutputView;
import lotto.service.purchase.PurchaseService;

public class PurchaseController extends LottoController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    protected void request(Model model) {
        String input = InputForm.read(PAY_AMOUNT);
        model.put(Key.LOTTO_PURCHASE, input);
    }

    @Override
    protected void handle(Model model) {
        String input = (String) model.get(Key.LOTTO_PURCHASE);
        int payAmount = Integer.parseInt(input);

        LottoPurchase purchase = purchaseService.purchase(payAmount);
        model.put(Key.LOTTO_PURCHASE, purchase);
    }

    @Override
    protected void response(Model model) {
        LottoPurchase purchase = (LottoPurchase) model.get(Key.LOTTO_PURCHASE);
        OutputView.render(purchase);
    }
}
