package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            List<Lotto> purchasedLottos = purchaseAndShowLottos();
            LottoResult result = calculateAndShowResult(purchasedLottos);
            outputView.printWinningResult(result);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            run();
        }
    }

    private List<Lotto> purchaseAndShowLottos() {
        int amount = purchaseLotto();
        try {
            List<Lotto> lottos = lottoMachine.purchase(amount);
            outputView.outputPurchaseAmount(lottos.size());
            outputView.printLottos(lottos);
            return lottos;
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return purchaseAndShowLottos();
        }
    }

    private int purchaseLotto() {
        while (true) {
            try {
                return inputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private LottoResult calculateAndShowResult(List<Lotto> purchasedLottos) {
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber();
        return createLottoResult(purchasedLottos, winningLotto, bonusNumber);
    }

    private Lotto getWinningLotto() {
        while (true) {
            try {
                return new Lotto(inputView.inputWinningNumber());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                return inputView.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private LottoResult createLottoResult(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        LottoResult result = new LottoResult(purchasedLottos.size() * 1000);
        for (Lotto lotto : purchasedLottos) {
            result.addWinningResult(lotto, winningLotto, bonusNumber);
        }
        return result;
    }
}