package lotto;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        lottoPurchase.start();

        WinningNumbersInput winningNumbersInput = new WinningNumbersInput();
        winningNumbersInput.inputWinningNumbers();
    }
}
