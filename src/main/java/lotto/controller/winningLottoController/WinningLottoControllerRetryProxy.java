package lotto.controller.winningLottoController;

import lotto.aop.RetryHandler;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class WinningLottoControllerRetryProxy implements WinningLottoController {

    private final WinningLottoController target;
    private final RetryHandler retryHandler;

    public WinningLottoControllerRetryProxy(WinningLottoController target, RetryHandler retryHandler) {
        this.target = target;
        this.retryHandler = retryHandler;
    }

    @Override
    public Lotto readWinningNumbers() {
        return retryHandler.tryUntilSuccess(target::readWinningNumbers);
    }

    @Override
    public WinningLotto createWinningLotto(Lotto winningNumbers) {
        return retryHandler.tryUntilSuccess(() -> target.createWinningLotto(winningNumbers));
    }
}
