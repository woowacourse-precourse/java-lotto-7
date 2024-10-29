package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int getMoney() {
        OutputView.displayMoney();
        return Integer.parseInt(Console.readLine());
    }

    public static int getCount() {
        int count = Integer.parseInt(Console.readLine());
        OutputView.displayCount();
        return count;
    }

    public static int[] getWinningNumbers() {
        OutputView.displayWinningNumbers();
        String[] numbers = Console.readLine().trim().split(",");
        int[] numberWinner = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberWinner[i] = Integer.parseInt(numbers[i]);
        }
        return numberWinner;
    }

    public static int getBonusNumber() {
        OutputView.displayBonusNumber();
        return Integer.parseInt(Console.readLine());
    }
}
