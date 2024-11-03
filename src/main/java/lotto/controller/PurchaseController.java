package lotto.controller;

import lotto.service.TicketService;
import lotto.temp.IoController;
import lotto.util.CommonIo;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.function.Supplier;

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
        int amount = repeatUntilValid(() -> {
            String rawAmount = ioController.inputPurchaseAmount();
            return ioController.convertInputToInt(rawAmount);
        });
        ticketService.createTicket(amount);
        outputView.printTicketCount(ticketService.getTicketCount());
    }

    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException illegalArgumentException) {
            commonIo.printMessage(illegalArgumentException.getMessage());
            return repeatUntilValid(function);
        }
    }
}
