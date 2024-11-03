package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Money money = repeatUntilValid(this::getPurchaseMoney);
        outputView.displayPurchaseQuantity(money.getPurchaseQuantity());

        Lottos purchasedLottos = purchaseLotto(money);
        purchasedLottos.forEach(
                lotto -> outputView.displayPurchasedLottos(lotto.getSortedLottoString())
        );

        WinningLotto winningLotto = repeatUntilValid(this::getWinningLotto);
        BonusNumber bonusNumber = repeatUntilValid(() -> getBonusNumber(winningLotto));

        WinningResult winningResult = getWinningResult(purchasedLottos, winningLotto, bonusNumber);
        Profit profit = Profit.of(money, winningResult);
        outputView.displayWinningStatistics(winningResult.getWinningResultString(), profit.getProfitString());
    }

    private Money getPurchaseMoney() {
        outputView.requestPurchaseMoney();
        int inputPurchaseMoney = inputView.inputPurchaseMoney();
        return Money.from(inputPurchaseMoney);
    }

    private Lottos purchaseLotto(Money money) {
        return LottoMachine.create().issueLottos(money.getPurchaseQuantity());
    }

    private WinningLotto getWinningLotto() {
        outputView.requestWinningNumber();
        List<Integer> inputWinningNumber = inputView.inputWinningNumber();
        return WinningLotto.from(inputWinningNumber);
    }

    private BonusNumber getBonusNumber(WinningLotto winningLotto) {
        outputView.requestBonusNumber();
        int inputBonusNumber = inputView.inputBonusNumber();
        return BonusNumber.of(winningLotto, inputBonusNumber);
    }

    private WinningResult getWinningResult(Lottos lottos, WinningLotto winningLotto, BonusNumber bonusNumber) {
        WinningResult winningResult = WinningResult.create();
        winningResult.calculateWinningResult(lottos, winningLotto, bonusNumber);
        return winningResult;
    }

    private <T> T repeatUntilValid(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatUntilValid(supplier);
        }
    }
}
