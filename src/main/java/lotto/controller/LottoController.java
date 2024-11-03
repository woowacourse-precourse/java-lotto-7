package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
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
        Money money = repeatUntilValid(this::getLottoMoney);
        outputView.displayPurchaseQuantity(money.getPurchaseQuantity());

        Lottos purchasedLottos = purchaseLotto(money);
        outputView.displayPurchasedLottos(purchasedLottos);

        WinningLotto winningLotto = repeatUntilValid(this::getWinningLotto);
    }

    private Money getLottoMoney() {
        outputView.requestLottoMoney();
        int inputLottoMoney = inputView.inputLottoMoney();

        return Money.from(inputLottoMoney);
    }

    private Lottos purchaseLotto(Money money) {
        return LottoMachine.createLottoMachine().issueLottos(money.getPurchaseQuantity());
    }

    private WinningLotto getWinningLotto() {
        outputView.requestWinningLotto();
        List<Integer> inputWinningLotto = inputView.inputWinningLotto();

        return WinningLotto.from(inputWinningLotto);
    }

    private <T> T repeatUntilValid(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return repeatUntilValid(supplier);
        }
    }
}
