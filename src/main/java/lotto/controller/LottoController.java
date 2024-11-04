package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.dto.LottoResult;
import lotto.dto.PurchaseAmount;
import lotto.dto.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        PurchaseAmount purchaseAmount = getValidLottoPurchaseAmount();
        Lottos lottos = new Lottos(purchaseAmount);
        showLottoNumbers(purchaseAmount, lottos);

        Lotto winningLotto = getWinningNumbers();
    }

    public PurchaseAmount getValidLottoPurchaseAmount() {
        try {
            PurchaseAmount purchaseAmount = new PurchaseAmount(InputView.inputLottoPurchaseAmount());
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidLottoPurchaseAmount();
        }
    }

    public void showLottoNumbers(PurchaseAmount purchaseAmount, Lottos lottos) {
        LottoResult lottoResult = new LottoResult(
                purchaseAmount.getPurchaseAmount(),
                lottos.displayLottos());
        OutputView.printLottoResult(lottoResult);
    }

    public Lotto getWinningNumbers() {
        try {
            WinningNumbers winningNumbers = new WinningNumbers(InputView.inputWinningNumbers());
            return winningNumbers.getWinningLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }
}
