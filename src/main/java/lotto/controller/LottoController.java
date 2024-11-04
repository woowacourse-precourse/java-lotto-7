package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

import static java.lang.System.in;

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
        List<Lotto> lottos = service.issueLottos(lottoQuantity);
    }
}
