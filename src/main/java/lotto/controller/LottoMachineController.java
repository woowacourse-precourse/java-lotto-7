package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.utils.RetryUtil;
import lotto.view.InputView;
import lotto.view.ObjectConvertor;
import lotto.view.OutputView;

public class LottoMachineController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoMachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = RetryUtil.retry(this::readPurchaseAmount);

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount.getPurchaseAmount());
        outputView.printBuyingLottos(ObjectConvertor.convertBuyingLottos(lottoMachine.getBuyingLottos()));

        Lotto lotto = RetryUtil.retry(this::readLotto);
        Bonus bonus = RetryUtil.retry(() -> readBonus(lotto));

        WinningLotto winningLotto = new WinningLotto(lotto, bonus);

        WinningResult winningCount = lottoMachine.calculateWinningCount(winningLotto);
        outputView.printWinningCount(ObjectConvertor.convertWinningCount(winningCount));
        outputView.printRateOfReturn(winningCount.getRateOfReturn(purchaseAmount));
    }

    private PurchaseAmount readPurchaseAmount() {
        return new PurchaseAmount(inputView.readPurchaseAmount());
    }

    private Lotto readLotto() {
        return new Lotto(inputView.readWinningLotto());
    }

    private Bonus readBonus(Lotto winningLotto) {
        return new Bonus(inputView.readBonus(), winningLotto);
    }
}
