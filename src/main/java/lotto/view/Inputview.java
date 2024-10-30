package lotto.view;

public class Inputview {
    public static int inputMoney(int money) {
        if (money % 10 != 0) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    public static String inputWinningNumbers(String winningNumbers) {
        return winningNumbers;
    }

    public static int inputBonusNumber(int BonusNumber) {
        return BonusNumber;
    }
}
