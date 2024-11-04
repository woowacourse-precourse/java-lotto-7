package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.WinningChecker;
import lotto.validator.LottoValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static final int LOTTO_PRICE = 1000;

    public void run(){
        int purchaseAmount = InputView.getPurchaseAmount();
        int lottoCount = purchaseAmount / LOTTO_PRICE;

        List<Lotto> lottos = LottoGenerator.generateLottos(lottoCount);
        OutputView.printLottoCountAndNumbers(lottoCount, lottos);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        LottoValidator.validateWinningNumbers(winningNumbers);

        int bonusNumber = InputView.getBonusNumber();
        LottoValidator.validateBonusNumber(bonusNumber, winningNumbers);

        WinningChecker winningChecker = new WinningChecker(winningNumbers, bonusNumber);
        LottoResult lottoResult = new LottoResult(lottos, winningChecker, purchaseAmount);

        OutputView.printStatistics(lottoResult);
    }
}
