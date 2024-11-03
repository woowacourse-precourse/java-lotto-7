package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
                LottoService lottoService = new LottoService();
                lottoService.purchaseLottos(purchaseAmount);
                System.out.println();
                OutputView.printPurchasedLottos(lottoService.getPurchasedLottos());

                System.out.println();
                WinningNumbers winningNumbers = inputWinningNumbers();

                Map<LottoRank, Integer> results = lottoService.calculateResults(winningNumbers);
                int totalPrize = lottoService.calculateTotalPrize(results);
                double yield = lottoService.calculateYield(purchaseAmount, totalPrize);

                System.out.println();
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
                return InputView.inputPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private WinningNumbers inputWinningNumbers() {
        List<Integer> winningNumbers = inputWinningNumberList();
        int bonusNumber = inputBonusNumber(winningNumbers);
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private int inputBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                return InputView.inputBonusNumber(winningNumbers);
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
