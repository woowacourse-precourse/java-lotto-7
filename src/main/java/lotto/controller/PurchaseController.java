package lotto.controller;

import lotto.service.TicketService;
import lotto.temp.IoController;
import lotto.util.CommonIo;
import lotto.view.InputView;
import lotto.view.OutputView;

public class PurchaseController {
    private final InputView inputView;
    private final OutputView outputView;
    private final IoController ioController;
    private final TicketService ticketService;

    public PurchaseController(TicketService ticketService){
        this.inputView = new InputView(new CommonIo());
        this.outputView = new OutputView(new CommonIo());
        this.ioController = new IoController(new CommonIo());
        this.ticketService = ticketService;
    }

    public void purchaseLottos(){
        inputView.printRequestPurchase();
        String rawAmount = ioController.inputPurchaseAmount();
        int amount = ioController.convertInputToInt(rawAmount);
        ticketService.createTicket(amount);
        outputView.printTicketCount(ticketService.getTicketCount());
    }
}
