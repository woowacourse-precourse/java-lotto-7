package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView;
    OutputView outputView;
    LottoService service;

    public LottoController(InputView inputView, OutputView outputView, LottoService service){
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }
    public void run(){
        outputView.purchase();
        String purchaseInput = inputView.purchaseInput();
        int lottoQuantity = service.lottoQuantity(purchaseInput);
        outputView.quantity(lottoQuantity);

    }
}
