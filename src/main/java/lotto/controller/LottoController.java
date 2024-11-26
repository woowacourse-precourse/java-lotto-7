package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoMachine lottoMachine;

    public LottoController(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();

        int lottoCount = purchaseAmount.calculateLottoCount();
        LottoTickets lottoTickets = lottoMachine.generateLottoTickets(lottoCount);
        OutputView.printLottoTickets(lottoTickets);

        WinningLotto winningLotto = inputWinningLotto();

        LottoResult lottoResult = new LottoResult(lottoTickets, winningLotto);
        printResults(purchaseAmount, lottoResult);
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

    private WinningLotto inputWinningLotto() {
        Lotto winningNumbers = inputWinningNumbers();
        return inputBonusNumber(winningNumbers);
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

    private void printResults(PurchaseAmount purchaseAmount, LottoResult lottoResult) {
        OutputView.printResult(lottoResult);
        double profitRate = lottoResult.calculateProfitRate(purchaseAmount);
        OutputView.printProfitRate(profitRate);
    }
}
