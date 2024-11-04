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

        System.out.println("\n" + cnt + resultView.responseCntLotto());

        List<List<Integer>> lottoNumbersList = lottoService.lottoNumbers(cnt);
        for (List<Integer> lottoNumber : lottoNumbersList) {
            System.out.println(lottoNumber);
        }

        List<Integer> winningNumbers = inputView.requestLottoNumbers();
//        List<Integer> winningNumbers = lottoService.extractWinningNumbersFromString(str);

        int bonusNumber = inputView.requestBonusNumber();


        Map<String, Integer> matchCounts = lottoService.calculateWinningStatistics(lottoNumbersList, winningNumbers, bonusNumber);

        for (Map.Entry<String, Integer> entry : matchCounts.entrySet()) {
            System.out.printf("%s - %d개\n", entry.getKey(), entry.getValue());
        }

        Long totalPrize = lottoService.calculateTotalPrize(matchCounts);
        double yield = lottoService.calculateYield(totalPrize, purchaseAmount);
        System.out.printf(InfoMessage.RESPONSE_TOTAL_YIELD.getMessage(), yield);

    }
}
