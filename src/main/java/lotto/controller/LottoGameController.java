package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.CalProfitRate;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.LottoResultCalculator;
import lotto.model.Rank;
import lotto.utils.Convert;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void LottoGameRun() {
        int purchaseAmount = inputView.lottoMoneyInput();
        int lottoCount = purchaseAmount / 1000;

        String[] winningNumbersInput = inputView.lottoNumberInput();
        List<Integer> winningNumbers = Convert.convertToIntegerList(winningNumbersInput);
        int bonusNumber = inputView.bonusNumberInput();

        List<Lotto> purchasedLottos = LottoGenerator.generateLottos(lottoCount);
        outputView.displayLottoCount(lottoCount);
        outputView.displayLottoNumbers(purchasedLottos);

        Map<Rank, Integer> result = LottoResultCalculator.calculateResults(purchasedLottos, winningNumbers,
                bonusNumber);
        double earningsRate = CalProfitRate.calculateProfitRate(result, lottoCount);

        outputView.displayResults(result, earningsRate);
    }


}
