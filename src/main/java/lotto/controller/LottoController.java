package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCounter;
import lotto.domain.Money;
import lotto.service.LottoGenerator;
import lotto.service.LottoMachine;
import lotto.service.LottoNumberChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final LottoMachine lottoMachine;

    public LottoController() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoNumberChecker lottoNumberChecker = new LottoNumberChecker();
        this.lottoMachine = new LottoMachine(lottoGenerator, lottoNumberChecker);
    }

    public void start() {
        Money money = InputView.inputMoney();
        List<Lotto> purchasedLottos = lottoMachine.purchaseLottos(money);
        int purchaseCount = purchasedLottos.size();

        OutputView.displayPurchasedLottos(purchaseCount, purchasedLottos);

        Lotto winningLotto = InputView.inputWinningNumber();
        int bonusNumber = InputView.inputBonusNumber(winningLotto.getNumbers()).getBonusNumber();

        lottoMachine.checkWinningNumbers(purchasedLottos, winningLotto.getNumbers(), bonusNumber);

        LottoCounter rankCounter = lottoMachine.getRankCounter();
        OutputView.displayResults(rankCounter, money.getAmount());
    }
}