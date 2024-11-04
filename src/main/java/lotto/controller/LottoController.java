package lotto.controller;

import java.util.List;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoTicket;
import lotto.domain.WinningLotto;
import lotto.domain.WinningStatistics;
import lotto.util.InputValidator; // InputValidator import
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = new InputValidator();
    }

    public void run() {
        String purchasePriceInput;
        while (true) {
            purchasePriceInput = inputView.inputPurchasePrice();
            try {
                inputValidator.validatePurchasePrice(purchasePriceInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        LottoGenerator lottoGenerator = new LottoGenerator(purchasePriceInput);
        LottoTicket lottoTicket = lottoGenerator.generateLottoTicket();
        outputView.printLottoTickets(lottoTicket);

        String winningNumbersInput;
        List<Integer> winningNumbers;
        while (true) {
            winningNumbersInput = inputView.inputWinningNumbers();
            try {
                winningNumbers = inputValidator.validateWinningNumbers(winningNumbersInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String bonusNumberInput;
        int bonusNumber;
        while (true) {
            bonusNumberInput = inputView.inputBonusNumber();
            try {
                bonusNumber = inputValidator.validateBonusNumber(winningNumbers, bonusNumberInput);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        WinningStatistics winningStatistics = new WinningStatistics(lottoTicket.getCount());
        lottoTicket.getLottoTicket().forEach(lotto -> {
            winningStatistics.recordWinningStatistics(lotto.getNumbers(), winningLotto);
        });

        outputView.printWinningStatistics(winningStatistics.getRankCount());
        outputView.printTotalProfitRate(winningStatistics.calculateReturnOnInvestment());
    }
}