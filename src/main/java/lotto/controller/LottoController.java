package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
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
        printLottoInformation(lottos.count(), lottos.information());
        WinningNumbers winningNumbers = receiveWinningNumbers();
        BonusNumber bonusNumber = receiveBonusNumber();
        displayWinningStatistic(winningNumbers, bonusNumber);
    }

    private PurchaseAmount receivePurchaseAmount() {
        outputView.requestPurchaseAmount();
        return getValidInput(PurchaseAmount::new);
    }

    private Lottos drawLottoNumbers(int lottoCount) {
        Lottos lottos = new Lottos();
        LottoNumber lottoNumber = new LottoNumber();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoNumber.generate());
            lottos.add(lotto);
        }
        return lottos;
    }

    private void printLottoInformation(int lottoCount, String lottoInformation) {
        outputView.printLottoCount(lottoCount);
        outputView.printLottoInformation(lottoInformation);
    }

    private WinningNumbers receiveWinningNumbers() {
        outputView.requestWinningNumbers();
        return getValidInput(WinningNumbers::new);
    }

    private BonusNumber receiveBonusNumber() {
        outputView.requestBonusNumber();
        return getValidInput(BonusNumber::new);
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

    private void displayWinningStatistic(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        outputView.printWinningStatistic();
    }
}
