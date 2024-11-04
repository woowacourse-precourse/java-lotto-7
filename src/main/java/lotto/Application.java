package lotto;

import lotto.input.Amount;
import lotto.input.WinLotto;
import lotto.logic.Generate;
import lotto.logic.JudgeWinLotto;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int n = getPurchaseAmount();
        List<List<Integer>> purchasedLottos = Generate.run(n);

        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        JudgeWinLotto.calculateResults(purchasedLottos, winningNumbers, bonusNumber, n);

    }

    private static int getPurchaseAmount() {
        while (true) {
            try {
                return Amount.inputBuyPrice();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                return WinLotto.inputWinLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
               return WinLotto.inputBonusLotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
