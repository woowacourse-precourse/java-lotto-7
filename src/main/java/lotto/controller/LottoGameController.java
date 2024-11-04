package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public class LottoGameController {
    private final LottoInputView inputView = new LottoInputView();
    private final LottoOutputView outputView = new LottoOutputView();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void start() {
        int purchaseAmount = inputPurchaseAmount();
        List<Lotto> tickets = generateTickets(purchaseAmount);
        outputView.printTickets(tickets);

        List<Integer> winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningNumbers);

        Lotto winningLotto = new Lotto(winningNumbers);
        LottoResult result = lottoMachine.calculateResult(tickets, winningNumbers, bonusNumber);
        outputView.printResult(result, purchaseAmount);
    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                return inputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private List<Integer> inputWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputView.inputWinningNumbers();
                new Lotto(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = inputView.inputBonusNumber();
                Lotto.validateBonusNumber(winningNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    private List<Lotto> generateTickets(int purchaseAmount) {
        return lottoMachine.generateTickets(purchaseAmount);
    }
}
