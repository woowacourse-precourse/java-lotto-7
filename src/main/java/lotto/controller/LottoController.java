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
        try {
            int purchaseAmount = InputView.inputPurchaseAmount();
            LottoService lottoService = new LottoService();
            lottoService.purchaseLottos(purchaseAmount);
            OutputView.printPurchasedLottos(lottoService.getPurchasedLottos());

            WinningNumbers winningNumbers = inputWinningNumbers();

            Map<LottoRank, Integer> results = lottoService.calculateResults(winningNumbers);
            int totalPrize = lottoService.calculateTotalPrize(results);
            double yield = lottoService.calculateYield(purchaseAmount, totalPrize);

            OutputView.printResults(results, yield);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }

    private WinningNumbers inputWinningNumbers() {
        String winningNumbersInput = InputView.inputWinningNumbers();
        List<Integer> winningNumbers = parseWinningNumbers(winningNumbersInput);
        int bonusNumber = InputView.inputBonusNumber();
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private List<Integer> parseWinningNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }
}
