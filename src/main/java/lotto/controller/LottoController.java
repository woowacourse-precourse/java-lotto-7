package lotto.controller;

import java.util.InputMismatchException;
import java.util.List;
import lotto.Lotto;
import lotto.model.LottoDrawMachine;
import lotto.model.LottoPurchaseMachine;
import lotto.model.LottoWinningStatistics;
import lotto.util.parser.InputParser;
import lotto.util.validator.BonusNumberValidator;
import lotto.util.validator.PurchaseAmountValidator;
import lotto.util.validator.WinningNumberValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputParser = new InputParser();
    }

    public void run() {
        int purchaseAmount = getValidPurchaseAmount();
        List<Lotto> lottos = generateLottoTickets(purchaseAmount);
        outputView.printLottoTickets(lottos);

        List<Integer> winningNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber(winningNumbers);

        printStatistics(lottos, winningNumbers, bonusNumber, purchaseAmount);
    }

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                inputView.requestPurchaseAmount();
                String purchaseAmountInput = inputView.inputPurchaseAmount();
                PurchaseAmountValidator.validatePurchaseAmount(purchaseAmountInput);
                return Integer.parseInt(purchaseAmountInput.trim());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private List<Lotto> generateLottoTickets(int purchaseAmount) {
        LottoPurchaseMachine lottoPurchaseMachine = new LottoPurchaseMachine(purchaseAmount);
        return lottoPurchaseMachine.generateLottoTickets();
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                inputView.requestWinningNumber();
                String winNum = inputView.inputWinningNumber();
                List<Integer> winningNumbers = inputParser.getWinNumList(winNum);

                WinningNumberValidator.validateWinningNumbers(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException | InputMismatchException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                inputView.requestWinningBonusNumber();
                String bonusNumInput = inputView.inputWinningBonusNumber();
                BonusNumberValidator.validateBonusNumber(bonusNumInput, winningNumbers);
                return Integer.parseInt(bonusNumInput.trim());
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private void printStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber,
                                 int purchaseAmount) {
        LottoDrawMachine lottoDrawMachine = new LottoDrawMachine(winningNumbers, bonusNumber);
        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(lottos, lottoDrawMachine,
                purchaseAmount);
        outputView.printStatistics(lottoWinningStatistics);
    }
}
