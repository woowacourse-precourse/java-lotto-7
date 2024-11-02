package lotto.custom.controller;

import java.util.List;
import lotto.custom.model.Lottos;
import lotto.custom.service.BonusNumberService;
import lotto.custom.service.CalculateYieldService;
import lotto.custom.service.LottoPurchaseService;
import lotto.custom.service.LottoResultCheckerService;
import lotto.custom.service.WinningNumberService;
import lotto.custom.view.InputView;
import lotto.custom.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    private final LottoPurchaseService lottoPurchaseService;
    private final WinningNumberService winningNumberService;
    private final BonusNumberService bonusNumberService;

    private final LottoResultCheckerService lottoResultCheckerService;
    private final CalculateYieldService calculateYieldService;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        
        this.lottoPurchaseService = new LottoPurchaseService();
        this.winningNumberService = new WinningNumberService();
        this.bonusNumberService = new BonusNumberService();

        this.lottoResultCheckerService = new LottoResultCheckerService();
        this.calculateYieldService = new CalculateYieldService();
    }

    public void run() {
        Lottos myLottoTickets = tryPurchaseLotto();
        outputView.displayLottoCount(myLottoTickets.size());
        outputView.displayLottos(myLottoTickets);

        List<Integer> winningNumbers = selectWinningNumbers();
        int bonusNumber = selectBonusNumber(winningNumbers);

        List<Integer> result = lottoResultCheckerService.run(myLottoTickets, winningNumbers, bonusNumber);
        outputView.displayLottoResult(result);
        double yield = calculateYieldService.run(result, myLottoTickets);
        outputView.displayLottoYield(yield);
    }

    public Lottos tryPurchaseLotto() {
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
                winningNumbers = winningNumberService.run(winningNumbersInput);
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
                bonusNumber = bonusNumberService.run(winningNumbers, bonusNumberInput);
                break; // 예외가 발생하지 않으면 루프 종료
            } catch (IllegalArgumentException e) {
                outputView.displayErrorMessage(e.getMessage());
            }
        }
        return bonusNumber;
    }
}