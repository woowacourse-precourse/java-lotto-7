package lotto.custom.controller;

import java.util.List;
import lotto.custom.model.Lottos;
import lotto.custom.service.CalculateYieldService;
import lotto.custom.service.LottoDrawingService;
import lotto.custom.service.LottoPurchaseService;
import lotto.custom.service.LottoResultCheckerService;
import lotto.custom.view.InputView;
import lotto.custom.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    private final LottoPurchaseService lottoPurchaseService;
    private final LottoDrawingService lottoDrawingService;

    private final LottoResultCheckerService lottoResultCheckerService;
    private final CalculateYieldService calculateYieldService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();

        this.lottoPurchaseService = new LottoPurchaseService();
        this.lottoDrawingService = new LottoDrawingService();

        this.lottoResultCheckerService = new LottoResultCheckerService();
        this.calculateYieldService = new CalculateYieldService();
    }

    public void run() {
        Lottos myLottoTickets = purchaseLotto();
        outputView.displayLottoCount(myLottoTickets.size());
        outputView.displayLottos(myLottoTickets);

        List<Integer> winningNumbers = selectWinningNumbers();
        int bonusNumber = selectBonusNumber(winningNumbers);

        List<Integer> result = lottoResultCheckerService.run(myLottoTickets, winningNumbers, bonusNumber);
        outputView.displayLottoResult(result);
        double yield = calculateYieldService.run(result, myLottoTickets);
        outputView.displayLottoYield(yield);
    }

    public Lottos purchaseLotto() {
        Lottos lottos;
        while (true) {
            try {
                String purchaseAmountInput = inputView.inputPurchaseAmount();
                lottos = lottoPurchaseService.run(purchaseAmountInput);
                break; // 예외가 발생하지 않으면 루프 종료
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
        return lottos;
    }

    public List<Integer> selectWinningNumbers() {
        List<Integer> winningNumbers;
        while (true) {
            try {
                String winningNumbersInput = inputView.inputWinningNumbers();
                winningNumbers = lottoDrawingService.drawWinningNumbers(winningNumbersInput);
                break; // 예외가 발생하지 않으면 루프 종료
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
        return winningNumbers;
    }

    public int selectBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        while (true) {
            try {
                String bonusNumberInput = inputView.inputBonusNumber();
                bonusNumber = lottoDrawingService.drawBonusNumber(winningNumbers, bonusNumberInput);
                break; // 예외가 발생하지 않으면 루프 종료
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
        return bonusNumber;
    }
}