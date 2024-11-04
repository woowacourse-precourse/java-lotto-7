package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.Rank;
import lotto.model.Lotto;
import lotto.model.LottoCalculator;
import lotto.model.LottoGenerator;
import lotto.model.LottoResultChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    LottoCalculator lottoCalculator = new LottoCalculator();
    LottoGenerator lottoGenerator = new LottoGenerator();
    LottoResultChecker lottoResultChecker;

    public void run() {
        int payment = inputView.getPayment();
        lottoCalculator.setPayment(payment);

        int amount = lottoCalculator.getLottoAmount();
        outputView.printPurchasedLottoAmount(amount);

        List<Lotto> lottos = lottoGenerator.generateLottos(amount);
        outputView.printLottos(lottos);

        List<Integer> winningNumber = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber(winningNumber);
        lottoResultChecker = new LottoResultChecker(winningNumber, bonusNumber);
        lottoResultChecker.checkLottoResult(lottos);

        Map<Rank, Integer> lottoResult = lottoResultChecker.getLottoResult();
        outputView.printWinningStatic(lottoResult);

        lottoCalculator.setLottoResult(lottoResult);
        float earningRate = lottoCalculator.getEarningRateFrom();
        outputView.printEarningRate(earningRate);
    }
}