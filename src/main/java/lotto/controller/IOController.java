package lotto.controller;

import java.util.Set;
import lotto.Lotto;
import lotto.model.LottoTickets;
import lotto.view.input.InputBonusNumberView;
import lotto.view.input.InputPurchaseAmountView;
import lotto.view.input.InputWinningNumberView;
import lotto.view.output.OutputLottoNumbersView;

public class IOController {
    public static int setPurchaseAmount() {
        int purchaseAmount;
        while (true) {
            try {
                purchaseAmount = InputPurchaseAmountView.purchaseAmountInput();
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public static Set<Integer> setWinningNumber() {
        Set<Integer> winningNumber;
        while (true) {
            try {
                winningNumber = InputWinningNumberView.WinningNumbersInput();
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    public static int setBonusNumber(Set<Integer> winningNumber) {
        int bonusNumber;
        while (true) {
            try {
                bonusNumber = InputBonusNumberView.bonusNumberInput(winningNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println();
            }

        }
    }

    public static void outputLottoTickets(int purchaseAmount, LottoTickets lottoTickets) {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets.getTickets()) {
            OutputLottoNumbersView.lottoNumbersOutput(lotto);
        }
        System.out.println();
    }
}
