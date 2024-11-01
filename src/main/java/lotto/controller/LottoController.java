package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoIssuer;
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

        List<Integer> winningNumbers = consoleView.getWinningNumbers();
        Integer bonusNumbers = consoleView.getBonusNumber();


        // 로또 비교 ,,
    }
}
