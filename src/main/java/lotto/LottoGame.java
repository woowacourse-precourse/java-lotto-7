package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

public class LottoGame {
    private final InputView inputView;
    private final LottoMachine lottoMachine;

    public LottoGame() {
        this.inputView = new InputView();
        this.lottoMachine = new LottoMachine();
    }

    public void start() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        lottoMachine.purchaseLottos(purchaseAmount);
        lottoMachine.printLottos();

        WinningNumbers winningNumbers = inputView.inputWinningNumbers();
        BonusNumber bonusNumber = inputView.inputBonusNumber(winningNumbers);

        Result result = new Result(
                lottoMachine.getLottos(),
                winningNumbers.getNumbers(),
                bonusNumber.getBonusNumber()
        );
        result.calculate();
        result.printResult(purchaseAmount);
    }
}
