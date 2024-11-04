package lotto.controller;

import lotto.message.error.ErrorMessage;
import lotto.message.info.InfoMessage;
import lotto.model.service.LottoService;
import lotto.view.inputview.InputView;
import lotto.view.outputview.ResultView;

import java.util.List;
import java.util.Map;

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

        resultView.responseCntLotto(cnt);

        List<List<Integer>> lottoNumbersList = lottoService.lottoNumbers(cnt);
        resultView.responseLottoNumberList(lottoNumbersList);

        List<Integer> winningNumbers = inputView.requestLottoNumbers();
//        List<Integer> winningNumbers = lottoService.extractWinningNumbersFromString(str);

        int bonusNumber = inputView.requestBonusNumber();

        resultView.displayWinningStatistics();
        Map<String, Integer> matchCounts = lottoService.calculateWinningStatistics(lottoNumbersList, winningNumbers, bonusNumber);
        resultView.winningResult(matchCounts);

        Long totalPrize = lottoService.calculateTotalPrize(matchCounts);
        double yield = lottoService.calculateYield(totalPrize, purchaseAmount);
        resultView.totalPrize(yield);

    }
}
