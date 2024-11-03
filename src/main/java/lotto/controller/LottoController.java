package lotto.controller;

import lotto.domain.LottoTicketCalculator;
import lotto.domain.NumberGenerator;
import lotto.dto.GeneratedNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final LottoTicketCalculator lottoTicketCalculator;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public LottoController() {
        inputView = new InputView();
        lottoTicketCalculator = new LottoTicketCalculator();
        outputView = new OutputView();
        numberGenerator = new NumberGenerator();
    }

    public void run() {
        int numberOfTickets = lottoTicketCalculator.getLottoTicketsCount(inputView.inputMoney());
        GeneratedNumbers generatedNumbers = new GeneratedNumbers(
                numberGenerator.generatingNumbers(numberOfTickets));

        outputView.printNumberOfTickets(numberOfTickets);
        outputView.printGeneratedNumbersPair(generatedNumbers);
    }
}
