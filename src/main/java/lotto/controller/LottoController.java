package lotto.controller;


import java.util.Set;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;
import lotto.domain.WinningStatistics;
import lotto.generator.Generator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Generator generator;

    public LottoController(InputView inputView, OutputView outputView, Generator generator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generator = generator;
    }

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

    private int getPurchaseAmount() {
        outputView.showPurchaseAmountInputMessage();
        return inputView.inputPurchaseAmount();
    }

    private Set<Integer> getWinningNumbers() {
        outputView.showWinningNumbersInputMessage();
        return inputView.inputWinningNumbers();
    }

    private int getBonusNumber(Set<Integer> winningNumbers) {
        outputView.showBonusNumberInputMessage();
        return inputView.inputBonusNumber(winningNumbers);
    }

    private LottoTickets issueLottoTickets(int purchaseAmount) {
        LottoMachine lottoMachine = new LottoMachine(generator);
        LottoTickets lottoTickets = lottoMachine.getLottoTickets(purchaseAmount);
        outputView.showLottoCountAndNumbers(lottoTickets);
        return lottoTickets;
    }
}
