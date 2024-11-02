package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;

public class LottoController {

    public void run() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();
        Lotto winningNumbers = inputWinningNumbers();
        WinningLotto winningLotto = inputBonusNumber(winningNumbers);
    }

    private PurchaseAmount inputPurchaseAmount() {
        try {
            int amount = InputView.inputPurchaseAmount();
            return new PurchaseAmount(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    private Lotto inputWinningNumbers() {
        try {
            List<Integer> numbers = InputView.inputWinningNumbers();
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private WinningLotto inputBonusNumber(Lotto winningNumbers) {
        try {
            int bonusNumber = InputView.inputBonusNumber();
            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }
}
