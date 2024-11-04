package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
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

                LottoService lottoService = new LottoService();
                lottoService.purchaseLottos(purchaseAmount);
                OutputView.printPurchasedLottos(lottoService.getPurchasedLottos());

                WinningNumbers winningNumbers = inputWinningNumbers();

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
        List<Integer> winningNumbers = inputValidWinningNumbers();
        System.out.println();
        int bonusNumber = inputValidBonusNumber(winningNumbers);
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private List<Integer> inputValidWinningNumbers() {
        while (true) {
            try {
                List<Integer> winningNumbers = InputView.inputWinningNumbers();
                new Lotto(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = InputView.inputBonusNumber();
                validBonusNumber(bonusNumber, winningNumbers);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LottoConstants.LOTTO_MIN_NUMBER || bonusNumber > LottoConstants.LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
