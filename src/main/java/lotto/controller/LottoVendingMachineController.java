package lotto.controller;

import lotto.dto.PurchaseDTO;
import lotto.model.LottoVendingMachine;
import lotto.view.InputView;

public class LottoVendingMachineController {

    public static PurchaseDTO buy(InputView inputView) {
        Integer totalCost = inputView.inputSingleInteger(inputView::inputTotalCost);

        LottoVendingMachine store = new LottoVendingMachine(totalCost);

        return new PurchaseDTO(totalCost, store.issueLotto());
    }
}
