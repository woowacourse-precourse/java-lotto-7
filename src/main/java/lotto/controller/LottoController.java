package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.service.LottoService;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    LottoService lottoService = new LottoService();

    public void run() {
        buyLottoTicket();
        calculateReturnRate(checkLottoResult());
    }

    private void buyLottoTicket() {
        readBudget();
        OutputView.printLottoCount(lottoService.getLottoCount());
        List<String> lottoTicket = lottoService.createLottoTicket();
        OutputView.printLottoNumbers(lottoTicket);
    }

    private Map<Rank, Integer> checkLottoResult() {
        readWinningNumber();
        readBonusNumber();
        Map<Rank, Integer> result = lottoService.getResult();
        OutputView.printResult(result);
        return result;
    }

    private void calculateReturnRate(Map<Rank, Integer> result) {
        OutputView.printRateOfReturn(lottoService.getRateOfReturn(result));
    }

    private void readBudget() {
        try {
            int budget = InputView.readMoney();
            lottoService.createMoney(budget);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBudget();
        }
    }

    private void readWinningNumber() {
        try {
            List<Integer> winningNumbers = InputView.readWinningNumbers();
            lottoService.createWinningNumbers(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readWinningNumber();
        }
    }

    private void readBonusNumber() {
        try {
            int bonusNumber = InputView.readBonusNumber();
            lottoService.setBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBonusNumber();
        }
    }
}
