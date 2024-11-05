package lotto.service;

import lotto.enums.LottoRank;
import lotto.exception.LottoException;
import lotto.model.*;
import lotto.validation.LottoPurchaseValidation;
import lotto.validation.LottoValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int purchaseAmount = purchaseAmount();
        LottoPurchase lottoPurchase = new LottoPurchase(purchaseAmount);
        List<LottoTicket> tickets = createLottoTickets(lottoPurchase.lottoCount());

        outputView.displayTickets(tickets);

        Lotto winningLotto = winningNumbers();
        LottoMachine lottoMachine = new LottoMachine(winningLotto);

        Map<LottoRank, Integer> results = lottoMachine.match(tickets);
        outputView.displayResults(results, purchaseAmount);
    }

    private int purchaseAmount() {
        while (true) {
            try {
                String input = inputView.readPurchaseAmount();
                return LottoPurchaseValidation.validatePurchaseAmount(input);
            } catch (LottoException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private List<LottoTicket> createLottoTickets(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }

    private Lotto winningNumbers() {
        String winningNumbersInput = inputView.readWinningNumber();
        List<Integer> winningNumbers = LottoValidation.validateWinningNumbers(winningNumbersInput);
        return new Lotto(winningNumbers);
    }
}
