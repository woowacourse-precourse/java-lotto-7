package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoGenerator lottoGenerator;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoGenerator = new LottoGenerator();
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        Lottos lottos = issueLottos(purchaseAmount);
        WinningNumbers winningNumbers = inputWinningNumbers();
        BonusNumber bonusNumber = inputBonusNumber();
    }

    private PurchaseAmount inputPurchaseAmount() {
        outputView.printPurchaseAmountMessage();
        int purchaseAmount = inputView.inputPurchaseAmount();
        return PurchaseAmount.from(purchaseAmount);
    }

    private Lottos issueLottos(PurchaseAmount purchaseAmount) {
        int quantity = purchaseAmount.calculateQuantity();
        outputView.printQuantity(quantity);
        Lottos lottos = lottoGenerator.issue(quantity);
        outputView.printLottos(lottos);
        return lottos;
    }

    private WinningNumbers inputWinningNumbers() {
        outputView.printWinningNumbersMessage();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        return WinningNumbers.from(winningNumbers);
    }

    private BonusNumber inputBonusNumber() {
        outputView.printBonusNumberMessage();
        int bonusNumber = inputView.inputBonusNumber();
        return BonusNumber.from(bonusNumber);
    }
}
