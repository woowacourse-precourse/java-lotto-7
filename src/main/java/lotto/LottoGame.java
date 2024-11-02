package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.LottoGenerator;
import lotto.domain.Result;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;

public class LottoGame {
    private final InputView inputView;
    private final LottoGenerator lottoGenerator;

    public LottoGame() {
        this.inputView = new InputView();
        this.lottoGenerator = new LottoGenerator();
    }

    public void start() {
        int purchaseAmount = inputView.inputPurchaseAmount();
        lottoGenerator.purchaseLottos(purchaseAmount);
        lottoGenerator.printLottos();

        WinningNumbers winningNumbers = inputView.inputWinningNumbers();
        BonusNumber bonusNumber = inputView.inputBonusNumber(winningNumbers);

        Result result = new Result(
                lottoGenerator.getLottos(),
                winningNumbers.getNumbers(),
                bonusNumber.getBonusNumber()
        );
        result.calculate();
        result.printResult(purchaseAmount);
    }
}
