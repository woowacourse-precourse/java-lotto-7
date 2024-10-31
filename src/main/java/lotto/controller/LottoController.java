package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        String rawPurchaseAmount = receivePurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(rawPurchaseAmount);
        Lottos lottos = drawLottoNumbers(purchaseAmount.calculateLottoCount());
        printLottoInformation(lottos.count(), lottos.information());
        String rawWinningNumbers = receiveWinningNumbers();
        WinningNumbers winningNumbers = new WinningNumbers(rawWinningNumbers);
        String rawBonusNumber = receiveBonusNumber();
        BonusNumber bonusNumber = new BonusNumber(rawBonusNumber);
    }

    private String receivePurchaseAmount() {
        outputView.requestPurchaseAmount();
        return inputView.receiveString();
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

    private String receiveWinningNumbers() {
        outputView.requestWinningNumbers();
        return inputView.receiveString();
    }

    private String receiveBonusNumber() {
        outputView.requestBonusNumber();
        return inputView.receiveString();
    }
}
