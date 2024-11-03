package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        int purchaseAmount = inputView.purchaseLottoInput();
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> tickets = lottoMachine.purchaseLotto(purchaseAmount);

        outputView.printLottoTickets(tickets);

        List<Integer> winningNumbers = inputView.winningNumInput();
        int bonusNumber = inputView.inputBonus();

        LottoResult result = lottoMachine.calculateResult(tickets, winningNumbers, bonusNumber);
        outputView.printResult(result);
    }
}