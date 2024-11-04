package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Rank;
import lotto.domain.Validator;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        String purchaseAmountInput = InputView.inputPurchase();
        int purchaseAmount = Validator.validateAndParsePurchaseAmount(purchaseAmountInput);

        List<Lotto> lottos = LottoGenerator.generateLottos(purchaseAmount);
        OutputView.printPurchasedLottos(lottos);

        String winningNumbersInput = InputView.inputWinningNumbers();
        String bonusNumberInput = InputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbersInput, bonusNumberInput);

        Map<Rank, Integer> results = winningLotto.calculateResults(lottos);

        OutputView.printWinningStatistics(results);
    }
}
