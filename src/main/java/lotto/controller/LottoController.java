package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Set;

public class LottoController {
    public void run() {
        int lottoAmount = InputView.buyLotto();

        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<Lotto> lottos = generator.generate(lottoAmount);
        Lottos purchasedLottos = new Lottos(lottos);

        OutputView.printLottoNumberOutput(lottoAmount, lottos);

        Set<Integer> winningNumbers = InputView.inputWinningNumber();
        WinningNumber winningNumber = new WinningNumber(winningNumbers);

        int bonusNumberValue = InputView.inputBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(bonusNumberValue);

        LottoCalculator calculator = new LottoCalculator(purchasedLottos, bonusNumber, winningNumber);
        List<LottoNumberCounter> counters = calculator.calculateMatching();
        int[] lottoResult = calculator.getLottoResult(counters);

        LottoRound lottoRound = new LottoRound(lottoAmount);
        double profitRate = calculator.calculateProfitRate(lottoResult, lottoRound);
        OutputView.printLottoStatistics(lottoResult, profitRate);
    }
}
