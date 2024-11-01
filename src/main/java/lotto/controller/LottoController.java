package lotto.controller;

import java.math.BigDecimal;
import java.util.List;
import lotto.model.Lotto;
import lotto.service.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    LottoMachine lottoMachine = new LottoMachine();

    public void run() {
        List<Lotto> Tickets = buyLotto();
        List<Integer> winningNumber = InputView.inputWinningNumber();
        InputView.inputBonusNumber(winningNumber);
    }

    private List<Lotto> buyLotto() {
        while (true) {
            try {
                List<Lotto> tickets;
                BigDecimal purchasePrice;

                purchasePrice = InputView.inputPurchasePrice();
                tickets = lottoMachine.createLottoTicket(purchasePrice);
                return tickets;
            } catch (NumberFormatException e) {
                OutputView.errorPrint(e.getMessage());
            } catch (IllegalArgumentException e) {
                OutputView.errorPrint(e.getMessage());
            }
        }
    }
}