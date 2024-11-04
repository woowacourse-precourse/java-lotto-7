package lotto.controller;

import lotto.domain.Lotto;

import lotto.domain.Winning;
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
        outputView.purchasePrint();
        String purchaseInput = inputView.purchaseInput();
        int lottoQuantity = service.lottoQuantity(purchaseInput);
        outputView.quantityPrint(lottoQuantity);
        List<Lotto> lottos = service.issueLottos(lottoQuantity);
        outputView.lottosPrint(lottos);
        outputView.winningNumberPrint();
        String winningNumberInput = inputView.winningNumberInput();
        outputView.bonusNumberPrint();
        String bonusNumberInput = inputView.bonusNumberInput();
        List<Winning> results = Winning.FIRST.findWinningDetail(lottos, winningNumberInput, bonusNumberInput);
        outputView.resultPrint(results);
    }
}
