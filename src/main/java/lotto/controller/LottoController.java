package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.LottoConstants;
import lotto.domain.LottoRank;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            try {
                int purchaseAmount = inputPurchaseAmount();
                System.out.println();

                LottoService lottoService = new LottoService();
                lottoService.purchaseLottos(purchaseAmount);
                OutputView.printPurchasedLottos(lottoService.getPurchasedLottos());
                System.out.println();

                WinningNumbers winningNumbers = inputWinningNumbers();
                System.out.println();

                Map<LottoRank, Integer> results = lottoService.calculateResults(winningNumbers);
                int totalPrize = lottoService.calculateTotalPrize(results);
                double yield = lottoService.calculateYield(purchaseAmount, totalPrize);

                OutputView.printResults(results, yield);
                isRunning = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputPurchaseAmount() {
        while (true) {
            try {
                int amount = InputView.inputPurchaseAmount();
                validatePurchaseAmount(amount);
                return amount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount % LottoConstants.LOTTO_PRICE != 0 || amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위의 양수여야 합니다.");
        }
    }

    private WinningNumbers inputWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = inputWinningNumberList();
                int bonusNumber = inputBonusNumber();
                return new WinningNumbers(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputBonusNumber() {
        while (true) {
            try {
                return InputView.inputBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> inputWinningNumberList() {
        while (true) {
            try {
                return InputView.inputWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
