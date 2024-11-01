package lotto.controller;

import java.util.Collections;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;

public class LottoMachineController {

    private final LottoMachine vendingMachine;

    public LottoMachineController(LottoMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public List<Lotto> purchase(Integer totalCost) {
        return Collections.unmodifiableList(vendingMachine.issueLotto(totalCost));
    }
}
