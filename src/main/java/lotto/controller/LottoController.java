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
        int lottoCount = getValidLottoCount();
        List<String> purchasedLottoNumber = purchaseService.purchaseLotto(lottoCount);
        OutputView.printPurchasedLotto(lottoCount, purchasedLottoNumber);

        setUserLottoNumbers();
        setBonusNumber();

        winningService.matchLotto(purchaseService.getPurchasedLotto(), userLotto);
        OutputView.printWinningResult();

        OutputView.printProfitRate(profitService.calculate(lottoCount));
    }

    private int getValidLottoCount() {
        while (true) {
            try {
                String purchaseAmount = InputView.readPurchaseAmount();
                return purchaseService.calculateLottoCount(purchaseAmount);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void setUserLottoNumbers() {
        while (true) {
            try {
                String userNumber = InputView.readUserNumber();
                userLotto.setNumbers(userNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void setBonusNumber() {
        while (true) {
            try {
                String bonusNumber = InputView.readBonusNumber();
                userLotto.setBonusNumber(bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
