package lotto.controller;

import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        int purchaseAmount = readPurchaseAmount();
        List<LottoTicket> purchasedTickets = purchaseLottoTickets(purchaseAmount);
        OutputView.printPurchasedLottoTickets(purchasedTickets);

        WinningLotto winningLotto = readWinningLotto();
        OutputView.printStatistics(purchasedTickets, winningLotto, purchaseAmount);
    }

    private int readPurchaseAmount() {
        try {
            String input = InputView.inputPurchaseAmount();
            Validator.validatePurchaseAmount(input);
            int amount = Integer.parseInt(input);
            return amount;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readPurchaseAmount();
        }
    }

    private List<LottoTicket> purchaseLottoTickets(int amount) {
        LottoMachine lottoMachine = new LottoMachine();
        int ticketCount = amount / LottoMachine.LOTTO_PRICE;
        return lottoMachine.publishTickets(ticketCount);
    }

    private WinningLotto readWinningLotto() {
        try {
            String winningNumbersInput = InputView.inputWinningNumbers();
            List<Integer> winningNumbers = InputView.parseNumbers(winningNumbersInput);
            Validator.validateWinningNumbers(winningNumbers);

            String bonusNumberInput = InputView.inputBonusNumber();
            int bonusNumber = Integer.parseInt(bonusNumberInput);
            Validator.validateBonusNumber(bonusNumber, winningNumbers);

            return new WinningLotto(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return readWinningLotto();
        }
    }
}
