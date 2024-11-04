package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MONEY_INPUT = "구입 금액을 입력해 주세요.";

    private static String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private static String moneyInput() {
        return input(MONEY_INPUT);
    }

    public static int getMoney() {
        while (true) {
            String inputMoney = InputView.moneyInput();
            try {
                return Integer.parseInt(inputMoney);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
