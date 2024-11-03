package lotto.controller;

import lotto.domain.LottoTicketCalculator;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView;
    private final LottoTicketCalculator lottoTicketCalculator;

    public LottoController() {
        inputView = new InputView();
        lottoTicketCalculator = new LottoTicketCalculator();
    }

    public void run() {
        int numberOfTickets = lottoTicketCalculator.getLottoTicketsCount(inputView.inputMoney());
    }
}
