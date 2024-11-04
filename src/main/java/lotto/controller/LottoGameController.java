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
        try {
            int purchaseAmount = inputView.inputPurchaseAmount();
            List<Lotto> tickets = generateTickets(purchaseAmount);
            outputView.printTickets(tickets);

            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            int bonusNumber = inputView.inputBonusNumber();

            Lotto winningLotto = new Lotto(winningNumbers);
            winningLotto.validateWinningNumbers(winningNumbers, bonusNumber);

            LottoResult result = lottoMachine.calculateResult(tickets, winningNumbers, bonusNumber);
            outputView.printResult(result, purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Lotto> generateTickets(int purchaseAmount) {
        return lottoMachine.generateTickets(purchaseAmount);
    }
}