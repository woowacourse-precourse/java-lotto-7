package lotto.controller;

import lotto.LottoManager;
import lotto.domain.PurchaseAmount;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;

public class LottoController {

    private final LottoManager lottoManager;

    public LottoController(LottoManager lottoManager) {
        this.lottoManager = lottoManager;
    }

    public void run() {
        PurchaseAmount purchaseAmount = repeatReadForInvalid(this::inputPurchaseAmount);
        List<Lotto> issuedLottos = lottoManager.CreateLotto(purchaseAmount);
        Output.printIssuedLottoDetails(issuedLottos);
    }

    private PurchaseAmount inputPurchaseAmount() {
        try {
            String input = Input.inputPurchaseAmount();
            int amount = Integer.parseInt(input);
            return new PurchaseAmount(amount);
        } catch (NumberFormatException e) {
            Output.printErrorMessage(new IllegalArgumentException("구매 금액은 숫자여야 합니다."));
            return inputPurchaseAmount();
        }
    }

    private <T> T repeatReadForInvalid(Supplier<T> reader) {
        while (true) {
            try {
                return reader.get();
            } catch (IllegalArgumentException e) {
                Output.printErrorMessage(e);
            }
        }
    }
}