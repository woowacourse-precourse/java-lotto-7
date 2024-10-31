package lotto.controller;

import static lotto.util.inputParser.parseInt;

import lotto.model.Price;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String rawPrice = inputView.readPriceInput();
        Price price = new Price(parseInt(rawPrice));
        int ticketCount = price.convertToTicket();
        outputView.printLottoTicket(ticketCount);

        inputView.closeConsole();
    }
}
