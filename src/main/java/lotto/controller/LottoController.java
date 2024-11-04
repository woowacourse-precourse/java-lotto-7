package lotto.controller;

import global.view.InputView;
import global.view.OutputView;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.service.LottoService;

public class LottoController {

    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void payingForLotto() {
        String inputPurchaseAmount = InputView.inputPurchaseAmount();
        try {
            lottoService.tryGenerateByPurchaseAmount(inputPurchaseAmount);
        } catch (Exception e) {
            payingForLotto();
            return;
        }
        OutputView.printLottoNumbers(lottoService.getAll());
    }

    public void checkLottoResult() {
        Map<LottoRank, Integer> matchedResults = lottoService.getMatchedResults();
        double profitRate = lottoService.calculateProfitRate(matchedResults);
        OutputView.printFinalResult(matchedResults, profitRate);
    }
}