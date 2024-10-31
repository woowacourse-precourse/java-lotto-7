package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningCount;
import lotto.domain.WinningNumbers;
import lotto.utils.RetryUtil;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachineController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoMachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = RetryUtil.retry(this::makePurchaseAmount);

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount.getPurchaseAmount());
        outputView.printBuyingLottos(lottoMachine.getLottoNumbers());

        Lotto winningLotto = RetryUtil.retry(this::makeWinningLotto);
        Bonus bonus = RetryUtil.retry(() -> makeBonus(winningLotto));

        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonus);

        WinningCount winningCount = lottoMachine.calculateWinningCount(winningNumbers);
        outputView.printWinningCount(winningCount.getWinning());
        outputView.printRateOfReturn(winningCount.getRateOfReturn(purchaseAmount));
    }

    private PurchaseAmount makePurchaseAmount() {
        return new PurchaseAmount(inputView.readPurchaseAmount());
    }

    private Lotto makeWinningLotto() {
        return new Lotto(inputView.readWinningLotto());
    }

    private Bonus makeBonus(Lotto winningLotto) {
        return new Bonus(inputView.readBonus(), winningLotto);
    }
}
