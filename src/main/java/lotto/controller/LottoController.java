package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.LottosResult;
import lotto.model.LottosResultCalculator;
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
        LottosResult lottosResult = calculateLottosResult(lottos, winningNumbers, bonusNumber);
        showLottosResult(lottosResult);
    }

    private LottosResult calculateLottosResult(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        LottosResultCalculator lottosResultCalculator = LottosResultCalculator.of(lottos, winningNumbers, bonusNumber);
        lottosResultCalculator.calculateLottosResult();
        return lottosResultCalculator.getLottosResult();
    }

    private void showLottosResult(LottosResult lottosResult) {
        outputView.showLottosResult(lottosResult);
    }

    private PurchaseAmount inputPurchaseAmount() {
        outputView.printPurchaseAmountMessage();
        int purchaseAmount = inputView.inputPurchaseAmount();
        outputView.nextLine();
        return PurchaseAmount.from(purchaseAmount);
    }

    private Lottos issueLottos(PurchaseAmount purchaseAmount) {
        int quantity = purchaseAmount.calculateQuantity();
        outputView.printQuantity(quantity);
        Lottos lottos = lottoGenerator.issue(quantity);
        outputView.printLottos(lottos);
        outputView.nextLine();
        return lottos;
    }

    private WinningNumbers inputWinningNumbers() {
        outputView.printWinningNumbersMessage();
        List<Integer> winningNumbers = inputView.inputWinningNumbers();
        outputView.nextLine();
        return WinningNumbers.from(winningNumbers);
    }

    private BonusNumber inputBonusNumber() {
        outputView.printBonusNumberMessage();
        int bonusNumber = inputView.inputBonusNumber();
        outputView.nextLine();
        return BonusNumber.from(bonusNumber);
    }
}
