package lotto.controller;

import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoBuyer;
import lotto.model.lotto.LottoStore;
import lotto.model.lotto.LottoTickets;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        try {
            int ticketCount = readValidTicketCount();
            outputView.printTicketNumber(ticketCount);
            LottoTickets lottoTickets = LottoTickets.createTickets(ticketCount);
            outputView.printLottoTickets(lottoTickets);

            Lotto winningNumber = new Lotto(inputView.readWinningNumber());

        } catch (IllegalArgumentException | IllegalStateException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private int readValidTicketCount() {
        while (true) {
            try {
                int budget = inputView.readBudget();
                LottoStore store = new LottoStore();
                LottoBuyer buyer = new LottoBuyer();
                buyer.buyTickets(budget, store);
                return buyer.getOwnedTickets();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }
}