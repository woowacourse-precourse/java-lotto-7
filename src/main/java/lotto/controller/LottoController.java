package lotto.controller;

import lotto.constant.LottoResultsTracker;
import lotto.domain.LottoTickets;
import lotto.domain.WinningNumbers;
import lotto.service.CalculatorService;
import lotto.service.LottoMachineService;
import lotto.service.WinningNumbersService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoTickets lottoTickets = buyLottoAndPrintTickets();
        WinningNumbers winningNumbers = inputWinningNumbers();
        int bonusNumber = inputBonusNumber();
        LottoResultsTracker lottoResultsTracker = getLottoResultstracker(lottoTickets, winningNumbers, bonusNumber);
        OutputView.LottoResultOutcome(lottoResultsTracker);
    }

    private LottoTickets buyLottoAndPrintTickets() {
        LottoMachineService lottoMachineService = new LottoMachineService();
        String inputPurchaseAmount = InputView.inputPurchaseAmount();
        try {
            LottoTickets lottoTickets = lottoMachineService.createLottoTickets(inputPurchaseAmount);
            OutputView.LottoTicketsOutCome(lottoTickets);
            return lottoTickets;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLottoAndPrintTickets();
        }
    }

    private WinningNumbers inputWinningNumbers() {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        String winningNumbers = InputView.inputPrimaryNumber();
        try {
            return winningNumbersService.createWinningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    private int inputBonusNumber() {
        try {
            return InputView.inputBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber();
        }
    }

    private LottoResultsTracker getLottoResultstracker(LottoTickets lotto, WinningNumbers winningNumbers, int bonus) {
        CalculatorService calculatorService = new CalculatorService(new WinningNumbersService());
        return calculatorService.calculateRankForWinningLotto(lotto, winningNumbers, bonus);
    }

}
