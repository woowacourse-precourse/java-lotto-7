package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.LottoEarningService;
import lotto.service.LottoIssueService;
import lotto.service.LottoRankService;
import lotto.service.LottoSortService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    private final LottoEarningService lottoEarningService;
    private final LottoIssueService lottoIssueService;
    private final LottoRankService lottoRankService;
    private final LottoSortService lottoSortService;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();

        lottoEarningService = new LottoEarningService();
        lottoIssueService = new LottoIssueService();
        lottoRankService = new LottoRankService();
        lottoSortService = new LottoSortService();
    }

    public void tryLotto() {
        outputView.askPayment();
        
        int numberOfLottos = inputView.inputPayment();
        List<Lotto> issuedLottos = lottoIssueService.issueLottos(numberOfLottos);
        outputView.alertBuyingNumber(numberOfLottos);

        List<List<Integer>> sortedNumbers = lottoSortService.sortLottos(issuedLottos);
        outputView.printSortedNumbers(sortedNumbers);


        outputView.askWinningNumbers();
        List<Integer> winningNumbers = inputView.inputWinningNumbersString();


        outputView.askBonusNumber();
        int bonusNumber = inputView.inputBonusNumberString(winningNumbers);


        outputView.alertStartStat();

        int[] rankCounts = lottoRankService.countRank(issuedLottos, winningNumbers, bonusNumber);
        outputView.printLottoResults(rankCounts);

        double earningRate = lottoEarningService.calculateEarningRate(rankCounts);
        outputView.alertEarningRate(earningRate);
    }
}
