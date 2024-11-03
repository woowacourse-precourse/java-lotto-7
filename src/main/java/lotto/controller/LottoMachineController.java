package lotto.controller;

import java.util.List;
import lotto.dto.LottoPurchaseDetails;
import lotto.model.LottoGroup;
import lotto.model.WinningLotto;
import lotto.util.NumLottoCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachineController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoMachineController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            LottoGroup purchasedLottos = purchaseLotto();
            WinningLotto winningLotto = requestWinningLotto();
        } catch (IllegalStateException e) {
            outputView.printExitMessage(e.getMessage());
        }
    }

    private LottoGroup purchaseLotto() {
        long purchaseAmount = requestPurchaseAmount();
        LottoGroup purchasedLottos = new LottoGroup(calcNumLotto(purchaseAmount));
        displayPurchaseDetails(purchasedLottos);

        return purchasedLottos;
    }

    private WinningLotto requestWinningLotto() {
        outputView.printWinningNumbersRequestMessage();
        List<Integer> winningNumbers = inputView.readWinningNumbers();

        outputView.printBonusNumberRequestMessage();
        int bonusNumber = inputView.readBonusNumber(winningNumbers);

        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private void displayPurchaseDetails(LottoGroup lottoGroup) {
        outputView.printPurchaseDetailsMessage(new LottoPurchaseDetails(lottoGroup));
    }

    private long calcNumLotto(long purchaseAmount) {
        return NumLottoCalculator.calculate(purchaseAmount);
    }

    private long requestPurchaseAmount() {
        outputView.printPurchaseAmountRequestMessage();
        return inputView.readPurchaseAmount();
    }
}
