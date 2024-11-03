package lotto.controller;

import lotto.domain.LottoTicketCalculator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final LottoTicketCalculator lottoTicketCalculator;
    private final OutputView outputView;

    public LottoController() {
        inputView = new InputView();
        lottoTicketCalculator = new LottoTicketCalculator();
        outputView = new OutputView();
    }

    public void run() {
        int numberOfTickets = lottoTicketCalculator.getLottoTicketsCount(inputView.inputMoney());
        outputView.printNumberOfTickets(numberOfTickets);
    }
}
