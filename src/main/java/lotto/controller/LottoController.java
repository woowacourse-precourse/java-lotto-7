package lotto.controller;

import lotto.message.error.ErrorMessage;
import lotto.model.service.LottoService;
import lotto.view.inputview.InputView;
import lotto.view.outputview.ResultView;

import java.util.List;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(LottoService lottoService, InputView inputView, ResultView resultView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        int purchaseAmount = inputView.requestPurchaseAmount();
        int cnt = lottoService.calculateLottoCount(purchaseAmount);
        System.out.println(cnt + resultView.responseCntLotto());
        List<List<Integer>> lottoNumbersList = lottoService.lottoNumbers(cnt);
        for (List<Integer> lottoNumber : lottoNumbersList) {
            System.out.println(lottoNumber);
        }

    }
}
