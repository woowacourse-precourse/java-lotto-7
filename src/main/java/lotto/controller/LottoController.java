package lotto.controller;


import java.util.Set;
import lotto.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.domain.WinningStatistics;
import lotto.generator.Generator;
import lotto.generator.RandomGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Generator generator = new RandomGenerator();

    public void run() {
        int purchaseAmount = getPurchaseAmount();
        LottoTickets lottoTickets = issueLottoTickets(purchaseAmount);

        Set<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        WinningStatistics winningStatistics = lottoTickets.getWinningStatistics(winningNumbers, bonusNumber);
        outputView.showResult(winningStatistics);

        double rateOfReturn = winningStatistics.calculateRateOfReturn(purchaseAmount);

        outputView.showRateOfReturn(rateOfReturn);
    }

    private int getBonusNumber(Set<Integer> winningNumbers) {
        outputView.showBonusNumberInputMessage();
        int bonusNumber = inputView.inputBonusNumber(winningNumbers);
        return bonusNumber;
    }

    private Set<Integer> getWinningNumbers() {
        outputView.showWinningNumbersInputMessage();
        Set<Integer> winningNumbers = inputView.inputWinningNumbers();
        return winningNumbers;
    }

    private LottoTickets issueLottoTickets(int purchaseAmount) {
        LottoMachine lottoMachine = new LottoMachine(generator);
        LottoTickets lottoTickets = lottoMachine.getLottoTickets(purchaseAmount);
        outputView.showLottoCountAndNumbers(lottoTickets);
        return lottoTickets;
    }

    private int getPurchaseAmount() {
        outputView.showPurchaseAmountInputMessage();
        return inputView.inputPurchaseAmount();
    }
}
