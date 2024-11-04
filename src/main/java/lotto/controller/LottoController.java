package lotto.controller;

import lotto.model.UserLotto;
import lotto.service.PurchaseService;
import lotto.service.ProfitService;
import lotto.service.WinningService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    UserLotto userLotto = new UserLotto();
    PurchaseService purchaseService = new PurchaseService();
    WinningService winningService = new WinningService();
    ProfitService profitService = new ProfitService();

    public void run() {
        String purchaseAmount = InputView.readPurchaseAmount();
        int lottoCount = purchaseService.calculateLottoCount(purchaseAmount);
        List<String> purchasedLottoNumber = purchaseService.purchaseLotto(lottoCount);
        OutputView.printPurchasedLotto(lottoCount, purchasedLottoNumber);

        String userNumber = InputView.readUserNumber();
        userLotto.setNumbers(userNumber);

        String bonusNumber = InputView.readBonusNumber();
        userLotto.setBonusNumber(bonusNumber);

        winningService.matchLotto(purchaseService.getPurchasedLotto(), userLotto);
        OutputView.printWinningResult();

        double profitRate = profitService.calculate(lottoCount);
        OutputView.printProfitRate(profitRate);
    }
}
