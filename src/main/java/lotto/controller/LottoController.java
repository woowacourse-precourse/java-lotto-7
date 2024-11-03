package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
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

    public void buyLotto() {
        String money = inputView.inputMoney();
        lottoService.buyLotto(money);
    }

    public void printLottoNumbers() {
        List<Lotto> lottos = lottoService.getAllLottos();
        outputView.printPurchaseCount(lottos.size());
        outputView.printLottoNumbers(lottos);
    }

    public Map<Rank, Integer> calculateLottoResults() {
        String winnerNumbers = inputView.inputWinnerNumbers();
        List<Integer> convertedWinnerNumbers = lottoService.convertToNumbers(winnerNumbers);
        String bonusNumber = inputView.inputBonusNumber(convertedWinnerNumbers);
        return lottoService.calculateLottoResults(winnerNumbers, bonusNumber);
    }

    public void printWinningStatistics(Map<Rank, Integer> rankCounts) {
        String percent = lottoService.getPercent(rankCounts);
        outputView.printWinningStatistics(rankCounts);
        outputView.printProfitRate(percent);
    }

    public void startLottoGame() {
        buyLotto();
        printLottoNumbers();
        Map<Rank, Integer> rankCounts = calculateLottoResults();
        printWinningStatistics(rankCounts);
    }
}
