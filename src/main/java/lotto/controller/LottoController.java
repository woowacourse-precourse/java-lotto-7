package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void run() {
        int purchaseAmount = getValidPurchaseAmount();
        List<Lotto> purchasedLottos = LottoService.purchaseLottos(purchaseAmount);
        OutputView.printLottos(purchasedLottos);

        List<Integer> winningNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber(winningNumbers);

        OutputView.printResult(LottoService.calculateResults(purchasedLottos, winningNumbers, bonusNumber));
        double yield = LottoService.calculateYield(purchasedLottos, winningNumbers, bonusNumber, purchaseAmount);
        OutputView.printYield(yield);
    }

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                return InputView.getPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 시도해 주세요.");
            }
        }
    }

    private List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                return InputView.getWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 시도해 주세요.");
            }
        }
    }

    private int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                int bonusNumber = InputView.getBonusNumber();
                if (winningNumbers.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 시도해 주세요.");
            }
        }
    }
}
