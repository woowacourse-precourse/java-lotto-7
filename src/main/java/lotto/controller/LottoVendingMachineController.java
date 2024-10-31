package lotto.controller;

import lotto.dto.PurchaseDTO;
import lotto.model.LottoVendingMachine;

public class LottoVendingMachineController {

    public static PurchaseDTO buy(Integer totalCost) {
        LottoVendingMachine vendingMachine = new LottoVendingMachine(totalCost);

        return new PurchaseDTO(totalCost, vendingMachine.issueLotto());
    }
}
