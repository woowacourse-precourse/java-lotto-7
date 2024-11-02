package lotto.controller;

import lotto.model.UserLotto;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    LottoService lottoService = new LottoService();
    UserLotto userLotto = new UserLotto();

    public void run() {
        String purchaseAmount = InputView.readPurchaseAmount();
        int lottoCount = lottoService.calculateLottoCount(purchaseAmount);
        lottoService.purchaseLotto(lottoCount);

        String userNumber = InputView.readUserNumber();
        userLotto.setNumbers(userNumber);

        String bonusNumber = InputView.readBonusNumber();
        userLotto.setBonusNumber(bonusNumber);


    }
}
