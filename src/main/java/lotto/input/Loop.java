package lotto.input;

import java.util.List;

public class Loop {

    public static int getPurchaseAmount() {
        while (true) {
            try {
                return Amount.inputBuyPrice();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> getWinningNumbers() {
        while (true) {
            try {
                return WinLotto.inputWinLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                return WinLotto.inputBonusLotto(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

