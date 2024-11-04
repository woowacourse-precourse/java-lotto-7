package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.dto.PurchaseAmountRequest;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        PurchaseAmountRequest purchaseAmountRequest = inputView.readPurchaseAmount();
        int lottoCount = lottoMachine.calculateLottoCount(purchaseAmountRequest.getAmount());
        outputView.printPurchasedLottoCount(lottoCount);

        Lottos lottos = lottoMachine.issueLottoTickets(lottoCount);

        outputView.printLottoTickets(lottos);
    }
}
