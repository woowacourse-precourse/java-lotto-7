package lotto.Controller;

import lotto.Model.LottoMachine;
import lotto.Model.LottoResult;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.Model.LottoRank;

import java.util.List;
import java.util.Map;

public class LottoController {
    public void run() {
        int purchaseAmount = promptPurchaseAmount();
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        OutputView.printPurchasedLottos(lottoMachine.getLottos());

        List<Integer> winningNumbers = promptWinningNumbers();
        int bonusNumber = promptBonusNumber(winningNumbers);

        LottoResult lottoResult = lottoMachine.determineLottoResult(winningNumbers, bonusNumber);
        OutputView.printResult(lottoResult);
        OutputView.printProfit(calculateProfitRate(lottoResult, purchaseAmount));
    }

    private int promptPurchaseAmount() {
        while (true) {
            try {
                return InputView.getPurchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> promptWinningNumbers() {
        while (true) {
            try {
                return InputView.getWinningNumbers();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int promptBonusNumber(List<Integer> winningNumber) {
        while (true) {
            try {
                int bonusNumber = InputView.getBonusNumber();
                if (winningNumber.contains(bonusNumber)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호와 겹치면 안됩니다.");
                }
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private double calculateProfitRate(LottoResult lottoResult, int purchaseAmount) {
        int totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : lottoResult.getResults().entrySet()) {
            int prize = entry.getKey().getPrize();
            int count = entry.getValue();
            totalPrize += prize * count;
        }
        return (double) totalPrize / purchaseAmount * 100;
    }
}
