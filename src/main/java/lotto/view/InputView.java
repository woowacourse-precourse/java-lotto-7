package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.MoneyValidator;
import lotto.validator.NumberValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static String getMoney() {
        OutputView.displayMoney();
        String inputMoney = Console.readLine().trim();

        getCount(inputMoney);
        return inputMoney;
    }

    public static void getCount(String inputMoney) {
        int money = Integer.parseInt(inputMoney);
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
