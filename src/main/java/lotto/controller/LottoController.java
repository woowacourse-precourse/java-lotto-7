package lotto.controller;

import lotto.service.ResultService;
import lotto.service.TicketService;
import lotto.domain.core.*;
import lotto.dto.result.*;
import lotto.handle.InputHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final InputHandler inputHandler = new InputHandler(inputView, outputView);
    private final TicketService ticketService = new TicketService(outputView);
    private final ResultService resultService = new ResultService(outputView);

    public void run() {
        PurchaseTotalPrice purchaseTotalPrice = inputHandler.handlePurchaseTotalPrice();
        IssuedTickets issuedTickets = ticketService.issueTickets(purchaseTotalPrice);

        Lotto lotto = inputHandler.handleLottoNumbers();
        Bonus bonus = inputHandler.handleBonusNumber(lotto);
        resultService.processResults(issuedTickets, lotto, bonus, purchaseTotalPrice);
    }
}
