package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoService;
import lotto.model.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        validPurchaseAmount();
        outputView.printLottoList(lottoService.getLottoList());

        Lotto winningNumber = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber();

        Map<Rank, Integer> result = lottoService.calculateResults(winningNumber, bonusNumber);
        double profit = lottoService.calculateProfit(result);
        outputView.printResults(result, profit);
    }

    private void validPurchaseAmount() {
        while (true) {
            try {
                int purchaseAmount = inputView.inputPurchaseAmount();
                lottoService.buyLotto(purchaseAmount);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getValidWinningNumbers() {
        while (true) {
            try {
                return inputView.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber() {
        while (true) {
            try {
                int bonusNumber = inputView.inputBonusNumber();
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
