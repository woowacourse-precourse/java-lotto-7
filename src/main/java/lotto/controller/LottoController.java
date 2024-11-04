package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Set;

public class LottoController {
    public void run() {
        int lottoAmount = getLottoAmount();
        Lottos purchasedLottos = purchaseLottos(lottoAmount);
        OutputView.printLottoNumberOutput(lottoAmount, purchasedLottos.getLottoNumbers());

        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber();

        LottoCalculator calculator = new LottoCalculator(purchasedLottos, bonusNumber, winningNumber);
        int[] lottoResult = calculateResults(calculator);

        LottoAmount lottoRound = new LottoAmount(lottoAmount);
        double profitRate = calculateProfitRate(calculator, lottoResult, lottoRound);

        OutputView.printLottoStatistics(lottoResult, profitRate);
    }

    private int getLottoAmount() {
        return InputView.inputLottoAmount();
    }

    private Lottos purchaseLottos(int lottoAmount) {
        LottoNumberGenerator generator = new LottoNumberGenerator();
        List<Lotto> lottos = generator.generate(lottoAmount);
        return new Lottos(lottos);
    }

    private WinningNumber getWinningNumber() {
        Set<Integer> winningNumbers = InputView.inputWinningNumber();
        return new WinningNumber(winningNumbers);
    }

    private BonusNumber getBonusNumber() {
        int bonusNumberValue = InputView.inputBonusNumber();
        return new BonusNumber(bonusNumberValue);
    }

    private int[] calculateResults(LottoCalculator calculator) {
        List<LottoNumberCounter> counters = calculator.calculateMatching();
        return calculator.getLottoResult(counters);
    }

    private double calculateProfitRate(LottoCalculator calculator, int[] lottoResult, LottoAmount lottoRound) {
        return calculator.calculateProfitRate(lottoResult, lottoRound);
    }
}
