package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinnerType;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Function;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = receivePurchaseAmount();
        Lottos lottos = drawLottoNumbers(purchaseAmount.calculateLottoCount());
        printLottoInformation(lottos.size(), lottos.information());
        WinningNumbers winningNumbers = receiveWinningNumbers();
        BonusNumber bonusNumber = receiveBonusNumber(winningNumbers);
        displayWinningStatistic(lottos, winningNumbers, bonusNumber);
        displayRateOfReturn(purchaseAmount);
    }

    private PurchaseAmount receivePurchaseAmount() {
        outputView.requestPurchaseAmount();
        return getValidInput(PurchaseAmount::new);
    }

    private Lottos drawLottoNumbers(int lottoCount) {
        Lottos lottos = new Lottos();
        LottoNumbers lottoNumbers = new LottoNumbers();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoNumbers.generate());
            lottos.add(lotto);
        }
        return lottos;
    }

    private void printLottoInformation(int lottoCount, String lottoInformation) {
        outputView.printLottoCount(lottoCount);
        outputView.printMessage(lottoInformation);
    }

    private WinningNumbers receiveWinningNumbers() {
        outputView.requestWinningNumbers();
        return getValidInput(WinningNumbers::new);
    }

    private BonusNumber receiveBonusNumber(WinningNumbers winningNumbers) {
        outputView.requestBonusNumber();
        return getValidInput(input -> new BonusNumber(input, winningNumbers));
    }

    private void displayWinningStatistic(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        outputView.printWinningStatisticHeader();
        lottos.calculateMatchingNumberCount(winningNumbers, bonusNumber);
        outputView.printMessage(WinnerType.information());
    }

    private void displayRateOfReturn(PurchaseAmount purchaseAmount) {
        double rateOfReturn = WinnerType.calculateRateOfReturn(purchaseAmount.calculateLottoCount());
        outputView.printRateOfReturn(rateOfReturn);
    }

    private <T> T getValidInput(Function<String, T> creationFunction) {
        while (true) {
            try {
                String input = inputView.receiveString();
                return creationFunction.apply(input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
