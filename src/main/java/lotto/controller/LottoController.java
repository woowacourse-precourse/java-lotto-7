package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoIssuer;
import lotto.model.LottoResult;
import lotto.model.LottoStatistics;
import lotto.view.ConsoleView;

public class LottoController {
    private final ConsoleView consoleView;
    private final LottoIssuer lottoIssuer;
    public LottoController(ConsoleView consoleView, LottoIssuer lottoIssuer) {
        this.consoleView = consoleView;
        this.lottoIssuer = lottoIssuer;
    }

    public void run() {
        Integer purchaseAmount = consoleView.getPurchaseLottoAmount();

        List<Lotto> issuedLottos = lottoIssuer.issueLotto(purchaseAmount);
        consoleView.printIssuedLotto(issuedLottos);

        List<Integer> winningNumbers = consoleView.getWinningNumbers();
        Integer bonusNumbers = consoleView.getBonusNumber();

        LottoStatistics lottoStatistics = new LottoStatistics(winningNumbers, bonusNumbers);
        List<LottoResult> lottoResults = lottoStatistics.updateResult(issuedLottos);

//        System.out.println(lottoResults);
    }
}
