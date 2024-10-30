package lotto.controller;

import lotto.dto.PurchaseDTO;
import lotto.model.LottoStore;
import lotto.view.InputView;

public class LottoStoreController {

    public static PurchaseDTO buy(InputView inputView) {
        Integer totalCost = inputView.inputSingleInteger(inputView::inputTotalCost);

        LottoStore store = new LottoStore(totalCost);

        return new PurchaseDTO(totalCost, store.issueLotto());
    }
}
