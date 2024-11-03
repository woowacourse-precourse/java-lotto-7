package lotto.controller;

import lotto.model.Money;
import lotto.model.Ticket;
import lotto.temp.IoController;
import lotto.util.CommonIo;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PurchaseController {
    private final InputView inputView;
    private final OutputView outputView;
    private final IoController ioController;

    public PurchaseController(){
        this.inputView = new InputView(new CommonIo());
        this.outputView = new OutputView(new CommonIo());
        this.ioController = new IoController(new CommonIo());
    }

    public void purchaseLottos(){
        inputView.printRequestPurchase();
        String rawAmount = ioController.inputPurchaseAmount();
        int amount = ioController.convertInputToInt(rawAmount);
        Money money = Money.of(amount);
        Ticket ticket = money.toTickets();
        outputView.printTicketCount(ticket.ticketCount());
    }
}
