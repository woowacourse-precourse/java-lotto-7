package lotto.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_BUY_MONEY_STR = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_STR = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_STR = System.lineSeparator() + "보너스 번호를 입력해 주세요.";

    public static String inputBuyMoney() {
        System.out.println(INPUT_BUY_MONEY_STR);
        return input();
    }

    public static String inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_STR);
        return input();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_STR);
        return input();
    }

    public static String input() {
        return Console.readLine();
    }

}
