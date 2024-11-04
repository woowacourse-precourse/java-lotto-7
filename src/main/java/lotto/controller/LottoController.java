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
        //실제 동작하는 코드입니다.
//        List<List<Integer>> lottoNumbersList = lottoService.lottoNumbers(cnt);

        //테스트용 리스트입니다.
        List<List<Integer>> lottoNumbersList = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
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
