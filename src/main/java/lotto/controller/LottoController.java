package lotto.controller;


import java.util.Set;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, OutputView outputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        LottoTickets lottoTickets = issueLottoTickets(purchaseAmount);

        Set<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        WinningStatistics winningStatistics = lottoTickets.getWinningStatistics(winningNumbers, bonusNumber);
        double rateOfReturn = winningStatistics.calculateRateOfReturn(purchaseAmount);
        showResult(winningStatistics, rateOfReturn);
    }

    private int getPurchaseAmount() {
        outputView.showPurchaseAmountInputMessage();
        return inputView.inputPurchaseAmount();
    }

    private LottoTickets issueLottoTickets(int purchaseAmount) {
        LottoTickets lottoTickets = lottoMachine.getLottoTickets(purchaseAmount);
        outputView.showLottoCountAndNumbers(lottoTickets);
        return lottoTickets;
    }

    private Set<Integer> getWinningNumbers() {
        outputView.showWinningNumbersInputMessage();
        return inputView.inputWinningNumbers();
    }

    private int getBonusNumber(Set<Integer> winningNumbers) {
        outputView.showBonusNumberInputMessage();
        return inputView.inputBonusNumber(winningNumbers);
    }

    private void showResult(WinningStatistics winningStatistics, double rateOfReturn) {
        outputView.showWinningStatistics(winningStatistics);
        outputView.showRateOfReturn(rateOfReturn);
    }
}
