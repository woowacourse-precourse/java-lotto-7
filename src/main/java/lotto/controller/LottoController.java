package lotto.controller;

import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.util.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputView.requestPurchaseAmount());
        outputView.printPurchaseAmount(purchaseAmount.getLottoQuantity());

        List<Integer> winningNumbers = Parser.parseStringToList(inputView.requestWinningNumbers());
        int bonusNumber = Parser.parseStringToInt(inputView.requestBonusNumber());
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), new BonusNumber(bonusNumber));
    }
}
