package lotto.controller;

import java.util.List;
import lotto.model.LottoService;
import lotto.model.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void run() {
        lottoService.createMoney(readBudget());
        OutputView.printLottoCount(lottoService.getLottoCount());
        List<String> lottoTicket = lottoService.createLottoTicket();
        OutputView.printLottoNumbers(lottoTicket);
        List<Integer> winningNumbers = readWinningNumber();
        readBonusNumber(winningNumbers);
        OutputView.printResult(lottoService.getResult());
        OutputView.printRateOfReturn(lottoService.getRateOfReturn());
    }

    private List<Integer> readWinningNumber() {
        try {
            return InputView.readWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWinningNumber();
        }
    }

    private int readBudget() {
        try {
            return InputView.readMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBudget();
        }
    }

    private void readBonusNumber(List<Integer> winningNumbers) {
        try {
            int bonusNumber = InputView.readBonusNumber();
            lottoService.createWinningNumbers(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBonusNumber(winningNumbers);
        }
    }
}
