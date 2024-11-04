package lotto.controller;

import lotto.service.TicketService;
import lotto.temp.IoComponent;

import static lotto.util.RepeatInput.repeatUntilValid;

public class PurchaseController {
    private final TicketService ticketService;
    private final IoComponent ioComponent;

    public PurchaseController(TicketService ticketService, IoComponent ioComponent) {
        this.ticketService = ticketService;
        this.ioComponent = ioComponent;
    }

    public void purchaseLottos() {
        ioComponent.getInputView().printRequestPurchase();
        repeatCreation();
        ioComponent.getOutputView().printTicketCount(ticketService.getTicketCount());
    }

    private void repeatCreation() {
        repeatUntilValid(() -> {
            String rawAmount = ioComponent.getIoController().inputPurchaseAmount();
            int amount = ioComponent.getIoController().convertInputToInt(rawAmount);
            ticketService.createTicket(amount);
            return null;
        }, ioComponent.getCommonIo());
    }
}
