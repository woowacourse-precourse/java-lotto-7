package lotto.controller;

import lotto.domain.Amount;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        Amount amount = getPurchaseAmount();
        Lottos lssuedLotto = lottoService.issueLottos(amount);
        outputView.displayIssuedLottos(lssuedLotto);
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
