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

    public void run() {
        long purchaseAmount = InputView.inputPurchaseAmount();
        System.out.println();

        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.start(purchaseAmount);
        List<Lotto> lottos = lottoMachine.getLottos();

        OutputView.printLotteryCount(lottos.size());
        OutputView.printLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        OutputView.print("\n");
        int bonusNumber = InputView.inputBonusNumber();
        OutputView.print("\n");

        LottoResults lottoResults = new LottoResults(purchaseAmount, lottos, winningNumbers, bonusNumber);
        lottoResults.calResults();
        Map<Rank, Integer> lottoStatics = lottoResults.getLottoStatics();
        double totalProfitRate = lottoResults.getTotalProfitRate();
        OutputView.printLottoStatics(lottoStatics);
        OutputView.printTotalProfitRate(totalProfitRate);
    }
}
