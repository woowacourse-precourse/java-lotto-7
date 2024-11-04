package lotto.controller;

import lotto.dto.LottoTicketDto;
import lotto.model.lotto.LottoBuyer;
import lotto.model.lotto.LottoStore;
import lotto.model.lotto.LottoTickets;
import lotto.util.RetryTemplate;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        lottoTickets = LottoTickets.createTickets(ticketCount);

        LottoTicketDto ticketDto = LottoTicketDto.from(lottoTickets);
        outputView.printTickets(ticketDto);
    }

    private int readValidTicketCount() {
        int budget = inputView.readBudget();
        LottoStore store = new LottoStore();
        LottoBuyer buyer = new LottoBuyer();
        buyer.buyTickets(budget, store);
        return buyer.getOwnedTickets();
    }
}