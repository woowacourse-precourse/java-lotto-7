package lotto.controller;

import java.util.List;
import lotto.domain.LottoTicketCalculator;
import lotto.domain.NumberGenerator;
import lotto.domain.SeparateNumbers;
import lotto.dto.GeneratedNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final LottoTicketCalculator lottoTicketCalculator;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private final SeparateNumbers separateNumbers;

    public LottoController() {
        inputView = new InputView();
        lottoTicketCalculator = new LottoTicketCalculator();
        outputView = new OutputView();
        numberGenerator = new NumberGenerator();
        separateNumbers = new SeparateNumbers();
    }

    public void run() {
        int numberOfTickets = lottoTicketCalculator.getLottoTicketsCount(inputView.inputMoney());
        GeneratedNumbers generatedNumbers = new GeneratedNumbers(
                numberGenerator.generatingNumbers(numberOfTickets));

        outputView.printNumberOfTickets(numberOfTickets);
        outputView.printGeneratedNumbersPair(generatedNumbers);

        String inputMainNumbers = inputView.inputNumbers();
        List<Integer> parsedInputNumbers = separateNumbers.separateInputNumbers(inputMainNumbers);
        int inputBonusNumber = Integer.parseInt(inputView.inputBonusNumber());

    }
}
