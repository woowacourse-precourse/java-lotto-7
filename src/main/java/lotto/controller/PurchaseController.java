package lotto.controller;

import lotto.service.TicketService;
import lotto.util.IoComponent;

import static lotto.util.common.RepeatInput.repeatUntilValid;

public class PurchaseController {
    private final TicketService ticketService;
    private final IoComponent ioComponent;

    public PurchaseController(TicketService ticketService, IoComponent ioComponent) {
        this.ticketService = ticketService;
        this.ioComponent = ioComponent;
    }

    public void purchaseLottos() {
        ioComponent.inputView().printRequestPurchase();
        repeatCreation();
        ioComponent.outputView().printTicketCount(ticketService.getTicketCount());
    }

    private void repeatCreation() {
        repeatUntilValid(() -> {
            String rawAmount = ioComponent.ioController().inputPurchaseAmount();
            int amount = ioComponent.ioController().convertInputToInt(rawAmount);
            ticketService.createTicket(amount);
            return null;
        }, ioComponent.commonIo());
    }
}
