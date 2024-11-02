package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.LottoCount;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, LottoService lottoService) {
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void run() {
        Amount amount = getPurchaseAmount();
        LottoCount lottoCount = LottoCount.from(amount);
        Lottos userLottos = lottoService.generateLottos(lottoCount);
    }

    private Amount getPurchaseAmount() {
        while (true) {
            try {
                inputView.printPurchaseAmountInputMessage();
                return Amount.of(inputView.getInput());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
