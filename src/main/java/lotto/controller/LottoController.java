package lotto.controller;

import lotto.domain.*;
import lotto.view.*;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoMachine = new LottoMachine();
    }

    public void play() {
        List<Lotto> lottos = purchaseLottos();
        WinningLotto winningLotto = createWinningLotto();
        LottoResult result = LottoResult.of(lottos, winningLotto);
        outputView.printResults(result);
    }

    private List<Lotto> purchaseLottos() {
        while (true) {
            try {
                int amount = inputView.readPurchaseAmount();
                List<Lotto> lottos = lottoMachine.purchase(amount);
                outputView.printPurchaseAmount(amount);
                outputView.printLottos(lottos);
                return lottos;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private WinningLotto createWinningLotto() {
        while (true) {
            try {
                List<Integer> numbers = inputView.readWinningNumbers();
                int bonusNumber = inputView.readBonusNumber();
                return new WinningLotto(new Lotto(numbers), bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}