package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Inputview {
    public static int inputMoney() {
        int money = Integer.parseInt(Console.readLine());
        if (money % 10 != 0) {
            throw new IllegalArgumentException();
        }
        return money;
    }

    public static String inputWinningNumbers() {
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
