package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResults;
import lotto.model.enums.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private LottoResults lottoResults;

    public void run() {
        long purchaseAmount = InputView.inputPurchaseAmount();
        System.out.println();

        List<Lotto> lottos = generateLottos(purchaseAmount);
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber(winningNumbers);

        lottoResults = new LottoResults(purchaseAmount, lottos, winningNumbers, bonusNumber);
        calculateAndDisplayResults();
    }

    private List<Lotto> generateLottos(long purchaseAmount) {
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.start(purchaseAmount);
        List<Lotto> lottos = lottoMachine.getLottos();
        printLottoResults(lottos);
        return lottos;
    }

    private void calculateAndDisplayResults() {
        lottoResults.calResults();
        Map<Rank, Integer> lottoStatistics = lottoResults.getLottoStatics();
        double totalProfitRate = lottoResults.getTotalProfitRate();

        OutputView.printLottoStatistics(lottoStatistics);
        OutputView.printTotalProfitRate(totalProfitRate);
    }

    private void printLottoResults(List<Lotto> lottos) {
        OutputView.printLotteryCount(lottos.size());
        OutputView.printLottos(lottos);
    }
}

