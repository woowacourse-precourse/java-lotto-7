package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static int getMoney() {
        OutputView.displayMoney();
        int money = Integer.parseInt(Console.readLine());
        getCount(money);
        return money;
    }

    public static void getCount(int money) {
        int count = money / 1000;
        OutputView.displayCount(count);
    }

    public static List<Integer> getWinningNumbers() {
        OutputView.displayWinningNumbers();
        String[] inputWinningNumbers = Console.readLine().trim().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < inputWinningNumbers.length; i++) {
            winningNumbers.add(Integer.parseInt(inputWinningNumbers[i]));
        }
        return winningNumbers;
    }

    public static int getBonusNumber() {
        OutputView.displayBonusNumber();
        return Integer.parseInt(Console.readLine());
    }
}
