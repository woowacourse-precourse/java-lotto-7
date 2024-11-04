package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        lottoPurchase.start();

        WinningNumbersInput winningNumbersInput = new WinningNumbersInput();
        List<Integer> winningNumbers = winningNumbersInput.inputWinningNumbers();

        BonusNumberInput bonusNumberInput = new BonusNumberInput();
        bonusNumberInput.inputBonusNumber(winningNumbers);
    }
}
