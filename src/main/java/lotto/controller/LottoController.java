package lotto.controller;

import java.util.Map;
import lotto.enums.Prize;
import lotto.model.LottoResultChecker;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoStore store;

    public LottoController() {
        this.store = new LottoStore();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Money money = getPurchaseAmount();
        Lottos lottos = store.purchaseLottos(money);
        outputView.printLottos(lottos);

        WinningNumbers winningNumbers = getWinningNumbers();

        LottoResultChecker lottoResultChecker = new LottoResultChecker(winningNumbers);
        Map<Prize, Integer> winningResult = lottoResultChecker.getLottosWinningResult(lottos);
        double yield = lottoResultChecker.getYield(winningResult, lottos);
        outputView.printResults(winningResult, yield);
    }

    private Money getPurchaseAmount() {
        Money money;
        while (true) {
            try {
                String purchaseAmount = inputView.getLottoPurchaseAmount();
                money = new Money(purchaseAmount);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return money;
    }

    private WinningNumbers getWinningNumbers() {
        WinningNumbers winningNumbers = null;
        while (true) {
            try {
                String numbersInput = inputView.getWinningNumbers();
                String bonusNumber = inputView.getBonusNumber();
                winningNumbers = new WinningNumbers(numbersInput, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }
}
