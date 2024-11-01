package lotto.controller;

import lotto.dto.LottoNumbers;
import lotto.model.Money;
import lotto.model.lotto.BonusNumber;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoMachine;
import lotto.model.lotto.Lottos;
import lotto.model.lotto.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        buyLotto();
        WinningLotto winningLotto = getWinningLotto();
    }

    private void buyLotto() {
        while (true) {
            try {
                final Money money = new Money(inputView.inputMoney());
                final Lottos lottos = lottoMachine.execute(money.calculateLottoCount());
                printBuyingLottos(money, lottos);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningLotto getWinningLotto() {
        while (true) {
            try {
                final Lotto lotto = new Lotto(inputView.inputLottoNumber());
                final BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
                return new WinningLotto(lotto, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printBuyingLottos(final Money money, final Lottos lottos) {
        outputView.printLottoCount(money.calculateLottoCount());
        LottoNumbers lottoNumbers = new LottoNumbers(lottos);
        outputView.printLottoNumbers(lottoNumbers);
    }
}
