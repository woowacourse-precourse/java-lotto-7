package lotto.controller;


import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.service.LottoValidationService;
import lotto.view.Input;
import lotto.view.Output;

public class LottoController {

    private final Input input;
    private final Output output;
    private final LottoValidationService lottoValidationService;

    public LottoController(Input input, Output output, LottoValidationService lottoValidationService) {
        this.input = input;
        this.output = output;
        this.lottoValidationService = lottoValidationService;
    }

    public void run() {
        PurchaseAmount purcharseAmount = requestPurchaseAmount();
        Lottos lottos = purchaseLotto(purcharseAmount.calculateLottoCount());
        output.printLottos(lottos);
    }

    private PurchaseAmount requestPurchaseAmount() {
        output.printPurchaseAmountPrompt();
        while (true) {
            try {
                String amountInput = input.getPurchaseAmount();
                int amount = lottoValidationService.validatePurchaseAmount(amountInput);
                return new PurchaseAmount(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lottos purchaseLotto(int count) {
        return Lottos.generateLottos(count);
    }

}
