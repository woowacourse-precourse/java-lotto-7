package lotto.controller;

import lotto.model.draw.Bonus;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoBuyer;
import lotto.model.lotto.LottoStore;
import lotto.model.lotto.LottoTickets;
import lotto.model.result.WinningStatistics;
import lotto.util.RetryTemplate;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.draw.LottoDraw;

import java.util.function.Supplier;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RetryTemplate retryTemplate;
    private LottoTickets lottoTickets;

    public LottoController(InputView inputView, OutputView outputView, RetryTemplate retryTemplate) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryTemplate = retryTemplate;
    }

    public LottoTickets buyLottoTickets() {
        retryTemplate.execute(this::buyTickets);
        return lottoTickets;
    }

    private void buyTickets() {
        int ticketCount = retryTemplate.execute(this::readValidTicketCount);
        outputView.printTicketNumber(ticketCount);

        lottoTickets = LottoTickets.createTickets(ticketCount);
        outputView.printLottoTickets(lottoTickets);
    }

    private int readValidTicketCount() {
        int budget = inputView.readBudget();
        LottoStore store = new LottoStore();
        LottoBuyer buyer = new LottoBuyer();
        buyer.buyTickets(budget, store);
        return buyer.getOwnedTickets();
    }
}