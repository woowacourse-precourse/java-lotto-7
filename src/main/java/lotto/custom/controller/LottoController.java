package lotto.custom.controller;

import java.util.List;
import lotto.custom.model.Lottos;
import lotto.custom.service.LottoPurchaseService;
import lotto.custom.service.WinningNumberService;
import lotto.custom.view.InputView;
import lotto.custom.view.OutputView;

public class LottoController {
    private final LottoPurchaseService lottoPurchaseService;
    private final WinningNumberService winningNumberService;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.lottoPurchaseService = new LottoPurchaseService();
        this.winningNumberService = new WinningNumberService();

        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Lottos myLottoTickets = tryPurchaseLotto();
        outputView.displayLottoCount(myLottoTickets.size());
        outputView.displayLottos(myLottoTickets);

        List<Integer> winningNumbers = selectWinningNumbers();
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
}