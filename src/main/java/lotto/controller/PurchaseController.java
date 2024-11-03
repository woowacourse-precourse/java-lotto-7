package lotto.controller;

import lotto.service.TicketService;
import lotto.temp.IoController;
import lotto.util.CommonIo;
import lotto.view.InputView;
import lotto.view.OutputView;

import static lotto.util.RepeatInput.repeatUntilValid;

public class PurchaseController {
    private final InputView inputView;
    private final OutputView outputView;
    private final IoController ioController;
    private final TicketService ticketService;
    private final CommonIo commonIo = new CommonIo();

    public PurchaseController(TicketService ticketService) {
        this.inputView = new InputView(commonIo);
        this.outputView = new OutputView(commonIo);
        this.ioController = new IoController(commonIo);
        this.ticketService = ticketService;
    }

    public void purchaseLottos() {
        inputView.printRequestPurchase();
        repeatUntilValid(() -> {
            String rawAmount = ioController.inputPurchaseAmount();
            int amount = ioController.convertInputToInt(rawAmount);
            ticketService.createTicket(amount);
            return amount;
        },commonIo);
        outputView.printTicketCount(ticketService.getTicketCount());
    }

}
