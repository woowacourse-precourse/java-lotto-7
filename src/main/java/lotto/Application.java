package lotto;

import lotto.input.Amount;
import lotto.input.WinLotto;
import lotto.logic.Generate;
import lotto.logic.JudgeWinLotto;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int n = getPurchaseAmount(); // 총 구매 금액 계산
        List<List<Integer>> purchasedLottos = Generate.run(n);  // 구매한 로또 번호 리스트

        List<Integer> winningNumbers = getWinningNumbers();  // 당첨 번호 입력
        int bonusNumber = getBonusNumber(winningNumbers);  // 보너스 번호 입력

        // 당첨 결과 계산 및 수익률 출력
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
